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

import org.gradle.api.tasks.testing.Test
import org.gradle.api.tasks.testing.TestDescriptor
import org.gradle.api.tasks.testing.TestListener
import org.gradle.api.tasks.testing.TestResult

kotlin {
    jvmToolchain(21)
}

android {
    val qaReleaseBuild = providers.gradleProperty("qaReleaseBuild").orNull == "true"
    val qaEmulatorBuild = providers.gradleProperty("qaEmulatorBuild").orNull == "true" || qaReleaseBuild

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
    val googleWebClientId = projectPropertyOrDefault("GOOGLE_WEB_CLIENT_ID").replace("\"", "\\\"")
    val kickOAuthBackendBaseUrl = projectPropertyOrDefault("KICK_OAUTH_BACKEND_BASE_URL", "https://kickauth.example.invalid").replace("\"", "\\\"")
    val kickOAuthBackendHmacSecret = projectPropertyOrDefault("KICK_OAUTH_BACKEND_HMAC_SECRET").replace("\"", "\\\"")
    // Fixed client token the official app sends as X-CLIENT-TOKEN when minting the viewer
    // watch socket token. Kept as a build-time value so a Kick rotation is an .env/-P change
    // (or an over-the-air update) instead of a source edit and a full release.
    // Deliberately NO hardcoded default: this file is published to the public repo, so a
    // baked-in value would be world-readable (and is extractable from Kick's own APK anyway).
    val kickViewerClientToken = projectPropertyOrDefault("KICK_VIEWER_CLIENT_TOKEN").replace("\"", "\\\"")
    val targetAbis = (project.findProperty("TARGET_ABI") as String?)
        ?.split(',')
        ?.map { it.trim() }
        ?.filter { it.isNotEmpty() }
        ?.takeIf { it.isNotEmpty() }
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
        it.substringAfterLast(':').replace("qaRelease", "", ignoreCase = true)
            .contains("release", ignoreCase = true)
    }

    val releaseSigningConfigured = releaseKeystoreFile.exists() &&
        releaseStorePassword.isNotEmpty() &&
        releaseKeyAlias.isNotEmpty() &&
        releaseKeyPassword.isNotEmpty()

    val verifyReleaseViewerToken = tasks.register("verifyReleaseViewerToken") {
        val viewerTokenConfigured = kickViewerClientToken.isNotBlank()
        doLast {
            check(viewerTokenConfigured) {
                "KICK_VIEWER_CLIENT_TOKEN is required to package a release. Set it via -P, " +
                    "the environment, Xtra/.env, or the release workflow secret."
            }
        }
    }
    tasks.matching { it.name == "packageRelease" || it.name == "packageReleaseBundle" }.configureEach {
        dependsOn(verifyReleaseViewerToken)
    }

    if (releaseSigningConfigured) {
        signingConfigs.create("release").apply {
            storeFile = releaseKeystoreFile
            storePassword = releaseStorePassword
            keyAlias = releaseKeyAlias
            keyPassword = releaseKeyPassword
        }
    }

    if (!qaEmulatorBuild && localDebugKeystoreFile.exists() &&
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

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
    }

    defaultConfig {
        applicationId = "com.github.andreyasadchy.xtrakick"
        minSdk = 26
        targetSdk = 36
        versionCode = 122
        versionName = "2.55.0"
    }

    buildTypes {
        debug {
            ndk {
                abiFilters += targetAbis ?: listOf("arm64-v8a")
            }
            if (!normalDebugPackage || qaEmulatorBuild) {
                applicationIdSuffix = ".test"
                versionNameSuffix = "-TEST"
            }
            val backendUrl = if (qaEmulatorBuild) "https://kickauth.example.invalid" else kickOAuthBackendBaseUrl
            buildConfigField("String", "KICK_CLIENT_ID", if (qaEmulatorBuild) "\"\"" else "\"$kickClientId\"")
            buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", if (qaEmulatorBuild) "\"\"" else "\"$googleWebClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$backendUrl\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_HMAC_SECRET", if (qaEmulatorBuild) "\"\"" else "\"$kickOAuthBackendHmacSecret\"")
            buildConfigField("String", "KICK_VIEWER_CLIENT_TOKEN", if (qaEmulatorBuild) "\"\"" else "\"$kickViewerClientToken\"")
        }
        release {
            ndk {
                abiFilters += targetAbis ?: listOf("arm64-v8a", "armeabi-v7a")
            }
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
            buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", "\"$googleWebClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$kickOAuthBackendBaseUrl\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_HMAC_SECRET", "\"$kickOAuthBackendHmacSecret\"")
            buildConfigField("String", "KICK_VIEWER_CLIENT_TOKEN", "\"$kickViewerClientToken\"")
        }
        if (qaReleaseBuild) {
            create("qaRelease") {
                initWith(getByName("release"))
                applicationIdSuffix = ".test"
                versionNameSuffix = "-QA"
                signingConfig = signingConfigs.getByName("debug")
                ndk.abiFilters.clear()
                ndk.abiFilters += "x86_64"
                buildConfigField("String", "KICK_CLIENT_ID", "\"\"")
                buildConfigField("String", "GOOGLE_WEB_CLIENT_ID", "\"\"")
                buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"https://kickauth.example.invalid\"")
                buildConfigField("String", "KICK_OAUTH_BACKEND_HMAC_SECRET", "\"\"")
                buildConfigField("String", "KICK_VIEWER_CLIENT_TOKEN", "\"\"")
            }
        }
    }
    if (qaReleaseBuild) {
        sourceSets.getByName("qaRelease").kotlin.directories.add("src/release/java")
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    androidResources {
        generateLocaleConfig = true
        localeFilters += listOf("en", "de", "es", "pt-rBR", "tr")
    }
    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.all {
            it.maxHeapSize = "2g"
        }
    }
    lint {
        checkReleaseBuilds = false
        error += setOf("NewApi", "InlinedApi")
        disable += listOf(
            "AlwaysShowAction",
            "AndroidGradlePluginVersion",
            "AppBundleLocaleChanges",
            "ChromeOsAbiSupport",
            "GradleDependency",
            "IntentFilterUniqueDataAttributes",
            "LeanbackUsesWifi",
            "MissingQuantity",
            "NewerVersionAvailable",
            "NonConstantResourceId",
            "NotifyDataSetChanged",
            "ObsoleteSdkInt",
            "OldTargetApi",
            "Overdraw",
            "PluralsCandidate",
            "PrivateResource",
            "SetTextI18n",
            "SmallSp",
            "SourceLockedOrientationActivity",
            "TypographyEllipsis",
            "Typos",
            "UseCompatLoadingForDrawables",
            "UseCompoundDrawables",
            "UseKtx",
            "UselessParent",
            "UseTomlInstead",
        )
    }
}

androidComponents {
    onVariants(selector().withBuildType("qaRelease")) { variant ->
        val code = providers.gradleProperty("qaVersionCode").orElse("2").map { value ->
            requireNotNull(value.toIntOrNull()?.takeIf { it in 1..2 }) { "qaVersionCode must be 1 or 2" }
        }
        variant.outputs.forEach { it.versionCode.set(code) }
    }

    onVariants(selector().withBuildType("release")) { variant ->
        val python = if (System.getProperty("os.name").startsWith("Windows")) "python" else "python3"
        val arguments = listOf(
            python, "-B", rootProject.file("gradle/release_version.py").absolutePath,
            "local", "--cache", rootProject.file(".gradle/published-release-version.json").absolutePath,
        ) + if (gradle.startParameter.isOffline) listOf("--offline") else emptyList()
        val publishedCode = providers.exec { commandLine(arguments) }.standardOutput.asText.map { it.trim() }
        val code = providers.gradleProperty("releaseVersionCode").orElse(publishedCode).map {
            val value = it.toIntOrNull()
            require(value != null && value in 1..2_100_000_000) { "Invalid releaseVersionCode: $it" }
            value
        }
        variant.outputs.forEach { it.versionCode.set(code) }
    }
}

dependencies {
    coreLibraryDesugaring(libs.desugar.jdk.libs)
    implementation("com.google.guava:guava:33.8.0-android") // exoplayer
    implementation("com.google.android.gms:play-services-cronet:18.1.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.11.0")
    implementation("androidx.credentials:credentials:1.3.0")
    implementation("com.google.android.libraries.identity.googleid:googleid:1.2.1")
    implementation("androidx.credentials:credentials-play-services-auth:1.3.0")
    implementation(libs.material)
    implementation(libs.markwon.core)
    implementation(libs.markwon.linkify)

    implementation(libs.activity)
    implementation(libs.appcompat)
    implementation(libs.constraintlayout)
    implementation(libs.coordinatorlayout)
    implementation(libs.core.ktx)
    implementation(libs.documentfile)
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
    debugImplementation(libs.okhttp.logging)
    implementation(libs.serialization.json)
    implementation(libs.ivs.player)

    implementation(libs.media3.datasource.cronet)
    implementation(libs.media3.datasource.okhttp)
    implementation(libs.media3.exoplayer)
    implementation(libs.media3.exoplayer.hls)
    implementation(libs.media3.ui)
    implementation(libs.media3.session)

    implementation(libs.coil)
    implementation(libs.coil.gif)
    implementation(libs.coil.okhttp)
    implementation(libs.coil.svg)
    implementation(libs.coil.video)
    implementation(libs.glide)
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
    testImplementation("org.robolectric:robolectric:4.18.1")
}

// Robolectric reaches FileDescriptor internals via jdk.internal.access.SharedSecrets,
// which JPMS hides by default. Export and open it for the unit-test JVM.
tasks.withType<Test> {
    if (System.getProperty("os.name").startsWith("Windows", ignoreCase = true)) {
        // Robolectric adds test names and app directories to SQLite paths. A nested temp root can exceed MAX_PATH.
        val userTemp = providers.environmentVariable("LOCALAPPDATA").orNull?.let { File(it, "Temp") }
        val gradleTemp = File(System.getProperty("java.io.tmpdir"))
        listOfNotNull(userTemp, gradleTemp)
            .filter { it.isDirectory && it.canWrite() }
            .minByOrNull { it.absolutePath.length }
            ?.let { systemProperty("java.io.tmpdir", it.absolutePath) }
    }
    if (providers.environmentVariable("GITHUB_ACTIONS").orNull == "true") {
        testLogging.events("failed")
        addTestListener(object : TestListener {
            private var completed = 0

            override fun beforeSuite(suite: TestDescriptor) {
                if (suite.parent == null) {
                    println("Test run started")
                }
            }
            override fun beforeTest(testDescriptor: TestDescriptor) = Unit

            override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {
                if (++completed % 100 == 0) {
                    println("Test progress: $completed tests finished")
                }
            }

            override fun afterSuite(suite: TestDescriptor, result: TestResult) {
                if (suite.parent == null) {
                    val seconds = (result.endTime - result.startTime) / 1000
                    println("Test summary: ${result.testCount} tests in ${seconds}s " +
                        "(${result.successfulTestCount} passed, " +
                        "${result.failedTestCount} failed, " +
                        "${result.skippedTestCount} skipped)")
                }
            }
        })
    }
    jvmArgs(
        "--add-exports=java.base/jdk.internal.access=ALL-UNNAMED",
        "--add-opens=java.base/jdk.internal.access=ALL-UNNAMED"
    )
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

detekt {
    buildUponDefaultConfig = true
    config.setFrom(file("$rootDir/config/detekt/detekt.yml"))
    baseline = file("$projectDir/detekt-baseline.xml")
}
