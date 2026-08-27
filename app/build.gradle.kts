plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "io.github.mucute.qwq.wakeupadblocker"
}

dependencies {
    compileOnly(libs.xposed.api)
}