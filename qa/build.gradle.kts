plugins {
    alias(libs.plugins.android.application)
}

kotlin {
    jvmToolchain(21)
}

android {
    namespace = "com.xtrakick.app.qa"
    compileSdk = 37
    defaultConfig {
        applicationId = "com.github.andreyasadchy.xtrakick.test.instrumentation"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1"
    }
}

androidComponents {
    beforeVariants(selector().withBuildType("release")) { it.enable = false }
}

dependencies {
    implementation("androidx.test:runner:1.7.0")
    implementation("androidx.test.ext:junit:1.3.0")
    implementation("androidx.test.uiautomator:uiautomator:2.3.0")
}
