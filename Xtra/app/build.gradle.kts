plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
    alias(libs.plugins.navigation.safeargs)
    alias(libs.plugins.apollo)
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

    fun projectPropertyOrDefault(name: String, default: String = ""): String {
        val fromEnv = System.getenv(name)?.trim()
        if (!fromEnv.isNullOrEmpty()) return fromEnv

        val fromDotEnv = dotEnv[name]?.trim()
        if (!fromDotEnv.isNullOrEmpty()) return fromDotEnv

        val fromGradleProp = (project.findProperty(name) as String?)?.trim()
        if (!fromGradleProp.isNullOrEmpty()) return fromGradleProp

        return default
    }

    val kickClientId = projectPropertyOrDefault("KICK_CLIENT_ID").replace("\"", "\\\"")
    val kickOAuthBackendBaseUrl = projectPropertyOrDefault("KICK_OAUTH_BACKEND_BASE_URL", "https://kickauth.example.invalid").replace("\"", "\\\"")
    val targetAbi = (project.findProperty("TARGET_ABI") as String?)?.trim()?.takeIf { it.isNotBlank() }
    val localDebugKeystorePath = projectPropertyOrDefault("LOCAL_DEBUG_KEYSTORE_FILE", "${project.projectDir}/debug-keystore.jks")
    val localDebugStorePassword = projectPropertyOrDefault("LOCAL_DEBUG_STORE_PASSWORD")
    val localDebugKeyAlias = projectPropertyOrDefault("LOCAL_DEBUG_KEY_ALIAS")
    val localDebugKeyPassword = projectPropertyOrDefault("LOCAL_DEBUG_KEY_PASSWORD")
    val localDebugKeystoreFile = file(localDebugKeystorePath)

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

    namespace = "com.github.andreyasadchy.xtra"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.github.andreyasadchy.xtrakick"
        minSdk = 23
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
            applicationIdSuffix = ".debug"
            versionNameSuffix = "-DEBUG"
            buildConfigField("String", "KICK_CLIENT_ID", "\"$kickClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$kickOAuthBackendBaseUrl\"")
        }
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            // Keep current behavior by using the default debug signing config unless a dedicated
            // release signing setup is introduced via local/CI Gradle properties.
            signingConfig = signingConfigs.getByName("debug")
            buildConfigField("String", "KICK_CLIENT_ID", "\"$kickClientId\"")
            buildConfigField("String", "KICK_OAUTH_BACKEND_BASE_URL", "\"$kickOAuthBackendBaseUrl\"")
        }
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
    androidResources {
        generateLocaleConfig = true
    }
    lint {
        disable += "ContentDescription"
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
    implementation("com.google.guava:guava:33.5.0-android") // exoplayer
    implementation("com.google.android.gms:play-services-cronet:18.1.1")
    implementation("com.google.mlkit:language-id:17.0.6")
    implementation("com.google.mlkit:translate:17.0.3")

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
    implementation(libs.apollo.api)

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

    implementation(libs.coroutines)
    testImplementation("junit:junit:4.13.2")
}

ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}

apollo {
    @Suppress("ApolloEndpointNotConfigured")
    service("service") {
        packageName.set("com.github.andreyasadchy.xtra.graphql")
    }
}

// Delete large build log files from ~/.gradle/daemon/X.X/daemon-XXX.out.log
// Source: https://discuss.gradle.org/t/gradle-daemon-produces-a-lot-of-logs/9905
File("${project.gradle.gradleUserHomeDir.absolutePath}/daemon/${project.gradle.gradleVersion}").listFiles()?.forEach {
    if (it.name.endsWith(".out.log")) {
        // println("Deleting gradle log file: $it") // Optional debug output
        it.delete()
    }
}
