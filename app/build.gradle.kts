plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.google.services)
    alias(libs.plugins.detekt)
}

kotlin {
    jvmToolchain(21)
}

android {
    val dotEnv = rootProject.file(".env").takeIf { it.exists() }?.readLines()
        ?.asSequence()
        ?.mapNotNull { line ->
            val trimmed = line.trim()
            if (trimmed.isBlank() || trimmed.startsWith("#")) return@mapNotNull null
            val delimiter = trimmed.indexOf('=')
            if (delimiter <= 0) return@mapNotNull null
            val key = trimmed.substring(0, delimiter).trim()
            val rawValue = trimmed.substring(delimiter + 1).trim()
            val value = rawValue.removeSurrounding("\"").removeSurrounding("'")
            if (key.isBlank()) null else key to value
        }
        ?.toMap()
        ?: emptyMap()

    /**
     * Resolution order, most specific first:
     *  1. -P on the command line, so a one-off build can always override.
     *  2. Environment (this is how CI supplies ORG_GRADLE_PROJECT_* values).
     *  3. Xtra/.env, the checked-out-but-ignored local defaults.
     *
     * .env used to win over -P, which meant a value present in .env could not be overridden
     * from the command line at all — including to unset a broken one.
     */
    fun projectPropertyOrDefault(name: String, default: String = ""): String {
        val fromGradleProp = (project.findProperty(name) as String?)?.trim()
        if (!fromGradleProp.isNullOrEmpty()) return fromGradleProp

        val fromEnv = System.getenv(name)?.trim()
        if (!fromEnv.isNullOrEmpty()) return fromEnv

        val fromDotEnv = dotEnv[name]?.trim()
        if (!fromDotEnv.isNullOrEmpty()) return fromDotEnv

        return default
    }

    val kickClientId = projectPropertyOrDefault("KICK_CLIENT_ID").replace("\"", "\\\"")
    val kickOAuthBackendBaseUrl = projectPropertyOrDefault("KICK_OAUTH_BACKEND_BASE_URL", "https://kickauth.example.invalid").replace("\"", "\\\"")
    val kickOAuthBackendHmacSecret = projectPropertyOrDefault("KICK_OAUTH_BACKEND_HMAC_SECRET").replace("\"", "\\\"")
    val targetAbi = (project.findProperty("TARGET_ABI") as String?)?.trim()?.takeIf { it.isNotBlank() }
    val localDebugKeystorePath = projectPropertyOrDefault("LOCAL_DEBUG_KEYSTORE_FILE", "${project.projectDir}/debug-keystore.jks")
    val localDebugStorePassword = projectPropertyOrDefault("LOCAL_DEBUG_STORE_PASSWORD")
    val localDebugKeyAlias = projectPropertyOrDefault("LOCAL_DEBUG_KEY_ALIAS")
    val localDebugKeyPassword = projectPropertyOrDefault("LOCAL_DEBUG_KEY_PASSWORD")
    val localDebugKeystoreFile = file(localDebugKeystorePath)
    val normalDebugPackage = (project.findProperty("NORMAL_DEBUG_PACKAGE") as String?)
        ?.toBooleanStrictOrNull()
        ?: false

    val releaseKeystorePath = projectPropertyOrDefault("RELEASE_KEYSTORE_FILE", "${project.projectDir}/release-keystore.jks")
    val releaseStorePassword = projectPropertyOrDefault("RELEASE_STORE_PASSWORD")
    val releaseKeyAlias = projectPropertyOrDefault("RELEASE_KEY_ALIAS")
    val releaseKeyPassword = projectPropertyOrDefault("RELEASE_KEY_PASSWORD")
    val releaseKeystoreFile = file(releaseKeystorePath)
    // Escape hatch for local development only. CI must never set this.
    val allowUnsignedRelease = projectPropertyOrDefault("ALLOW_UNSIGNED_RELEASE").toBooleanStrictOrNull() ?: false

    // Only hard-fail when a release artifact was actually asked for; a missing release keystore
    // must not block debug builds or IDE sync.
    val releaseTaskRequested = gradle.startParameter.taskNames.any {
        it.contains("Release", ignoreCase = false) || it.endsWith("release", ignoreCase = true)
    }

    val releaseSigningConfigured = releaseKeystoreFile.exists() &&
        releaseStorePassword.isNotEmpty() &&
        releaseKeyAlias.isNotEmpty() &&
        releaseKeyPassword.isNotEmpty()

    if (releaseSigningConfigured) {
        signingConfigs.create("release").apply {
            storeFile = releaseKeystoreFile
            storePassword = releaseStorePassword
            keyAlias = releaseKeyAlias
            keyPassword = releaseKeyPassword
        }
    }

    if (localDebugKeystoreFile.exists() &&
        localDebugStorePassword.isNotEmpty() &&
        localDebugKeyAlias.isNotEmpty() &&
        localDebugKeyPassword.isNotEmpty()
    ) {
        signingConfigs.getByName("debug").apply {
            storeFile = localDebugKeystoreFile
            storePassword = localDebugStorePassword
            keyAlias = localDebugKeyAlias
            keyPassword = localDebugKeyPassword
        }
    }

    namespace = "com.xtrakick.app"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.github.andreyasadchy.xtrakick"
        minSdk = 26
        targetSdk = 36
        versionCode = 121
        versionName = "2.54.0"
        if (targetAbi != null) {
            ndk {
                abiFilters += targetAbi
            }
        }
    }

    buildTypes {
        debug {
            if (!normalDebugPackage) {
                applicationIdSuffix = ".test"
                versionNameSuffix = "-TEST"
            }
            buildConfigField("String", "KICK_CLIENT_ID", "\"$kickClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$kickOAuthBackendBaseUrl\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_HMAC_SECRET", "\"$kickOAuthBackendHmacSecret\"")
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // Never fall back to the debug keystore here. Signing release builds with a key that
            // ships in the repo lets anyone build an APK Android accepts as an in-place update
            // over an installed copy, inheriting its stored OAuth tokens.
            signingConfig = if (releaseSigningConfigured) signingConfigs.getByName("release") else null
            if (!releaseSigningConfigured && !allowUnsignedRelease && releaseTaskRequested) {
                throw GradleException(
                    "Release signing is not configured. Set RELEASE_KEYSTORE_FILE, " +
                        "RELEASE_STORE_PASSWORD, RELEASE_KEY_ALIAS and RELEASE_KEY_PASSWORD " +
                        "(env vars, Xtra/.env, or -P properties), or pass " +
                        "-PALLOW_UNSIGNED_RELEASE=true to build an unsigned release locally."
                )
            }
            buildConfigField("String", "KICK_CLIENT_ID", "\"$kickClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$kickOAuthBackendBaseUrl\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_HMAC_SECRET", "\"$kickOAuthBackendHmacSecret\"")
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    androidResources {
        generateLocaleConfig = true
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
    lint {
        checkReleaseBuilds = false
        disable += listOf(
            "AlwaysShowAction",
            "AndroidGradlePluginVersion",
            "AppBundleLocaleChanges",
            "ChromeOsAbiSupport",
            "ContentDescription",
            "GradleDependency",
            "IntentFilterUniqueDataAttributes",
            "LeanbackUsesWifi",
            "MissingOnRenderProcessGone",
            "NewerVersionAvailable",
            "NonConstantResourceId",
            "NotifyDataSetChanged",
            "ObsoleteSdkInt",
            "OldTargetApi",
            "Overdraw",
            "PluralsCandidate",
            "PrivateResource",
            "SmallSp",
            "SourceLockedOrientationActivity",
            "TypographyEllipsis",
            "Typos",
            "UnsafeIntentLaunch",
            "UseCompatLoadingForDrawables",
            "UseCompoundDrawables",
            "UseKtx",
            "UselessParent",
            "UseTomlInstead",
        )
        disable += "MissingTranslation"
    }
    packaging.jniLibs.excludes.addAll(listOf(
        "lib/x86/libtranslate_jni.so",
        "lib/x86/liblanguage_id_l2c_jni.so",
        "lib/x86_64/libtranslate_jni.so",
        "lib/x86_64/liblanguage_id_l2c_jni.so",
        "lib/armeabi-v7a/libtranslate_jni.so",
        "lib/armeabi-v7a/liblanguage_id_l2c_jni.so",
    ))
}

dependencies {
    implementation("com.google.guava:guava:33.7.1-android") // exoplayer
    implementation("com.google.android.gms:play-services-cronet:18.1.1")
    implementation(libs.material)
    implementation(libs.markwon.core)
    implementation(libs.markwon.linkify)

    implementation(libs.activity)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.coordinatorlayout)
    implementation(libs.core.ktx)
    implementation(libs.fragment.ktx)
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)
    implementation(libs.paging.runtime)
    implementation(libs.preference.ktx)
    implementation(libs.recyclerview)
    implementation(libs.room.runtime)
    ksp(libs.room.compiler)
    implementation(libs.room.paging)
    implementation(libs.swiperefreshlayout)
    implementation(libs.viewpager2)
    implementation(libs.webkit)
    implementation(libs.work.runtime)

    implementation(libs.cronet.api)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.conscrypt)
    implementation(libs.serialization.json)
    implementation(libs.ivs.player)

    implementation(libs.media3.exoplayer)
    implementation(libs.media3.exoplayer.hls)
    implementation(libs.media3.ui)
    implementation(libs.media3.session)

    implementation(libs.coil)
    implementation(libs.coil.gif)
    implementation(libs.coil.okhttp)
    implementation(libs.coil.svg)

    implementation(libs.glide)
    ksp(libs.glide.ksp)
    implementation(libs.glide.okhttp)
    implementation(libs.glide.webpdecoder)

    implementation(libs.hilt)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.work)
    ksp(libs.hilt.extension.compiler)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.messaging)

    implementation(libs.coroutines)
    testImplementation("junit:junit:4.13.2")
// Real org.json for JVM tests — android.jar's stub throws "not mocked".
testImplementation("org.json:json:20260814")
    // ChatBackgroundUtilsTest computes its expected values with androidx ColorUtils,
    // which calls android.graphics.Color — absent on a plain JVM. Robolectric supplies it.
    testImplementation("org.robolectric:robolectric:4.16.1")
    // conscrypt-android ships JNI only for Android. Robolectric loads it on the JVM, so the
    // desktop build supplies the matching native library. Test runtime only.
    testImplementation("org.conscrypt:conscrypt-openjdk-uber:2.6.3")
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

detekt {
    buildUponDefaultConfig = true
    baseline = file("$projectDir/detekt-baseline.xml")
}
