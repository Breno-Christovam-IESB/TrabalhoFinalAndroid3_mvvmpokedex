// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.4.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
}

buildscript {
    extra.apply {
        set("compose_version", "1.6.7")
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:8.4.0")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
        // AVISO: Não coloque aqui as dependências da sua aplicação; elas pertencem
        // aos arquivos build.gradle do módulo 'app'
    }
}