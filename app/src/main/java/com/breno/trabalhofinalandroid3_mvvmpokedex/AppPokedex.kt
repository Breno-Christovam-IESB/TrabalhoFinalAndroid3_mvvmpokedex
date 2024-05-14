package com.breno.trabalhofinalandroid3_mvvmpokedex

import android.app.Application // Importa a classe Application do pacote android.app, necessária para criar a classe de aplicativo Android.
import android.content.Intent
import com.example.loginmodule.ui.login.LoginActivity
import dagger.hilt.android.HiltAndroidApp // Importa a anotação HiltAndroidApp do Dagger Hilt, que indica que a classe é a classe de aplicativo base para o Hilt.
import timber.log.Timber // Importa a classe Timber do Timber, uma biblioteca de registro para Android.

@HiltAndroidApp
class AppPokedex : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        // Inicia a LoginActivity a partir do contexto da aplicação
        val intent = Intent(applicationContext, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        applicationContext.startActivity(intent)
    }
}