// Top-level build file where you can add configuration options common to all sub-projects/modules.


buildscript {
    val compose_version by extra("1.2.0")
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