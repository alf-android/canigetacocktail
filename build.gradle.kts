// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {

    extra.apply {
        //UI
        set("composeVersion", "1.2.0")
        set("composeMaterialVersion", "1.2.1")
        set("composeMaterial3Version", "1.0.0-alpha01")
        //DB
        set("roomVersion", "2.4.3")
        //API
        set("okhttpVersion", "4.9.3")
        set("retrofitVersion", "2.9.0")
        set("gsonVersion", "2.9.0")
        set("gsonConverterVersion", "2.9.0")
    }

    repositories {
        maven("https://maven.google.com")
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("com.neenbedankt.gradle.plugins:android-apt:1.8")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.0")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.5.3")
    }
}

allprojects {

}

tasks.register<Delete>("clean").configure {
    delete(rootProject.buildDir)
}