package com.breno.trabalhofinalandroid3_mvvmpokedex

import android.app.Application // Importa a classe Application do pacote android.app, necessária para criar a classe de aplicativo Android.
import dagger.hilt.android.HiltAndroidApp // Importa a anotação HiltAndroidApp do Dagger Hilt, que indica que a classe é a classe de aplicativo base para o Hilt.
import timber.log.Timber // Importa a classe Timber do Timber, uma biblioteca de registro para Android.

@HiltAndroidApp
// Anotação que informa ao Dagger Hilt para gerenciar a criação e a vida útil desta classe Application.
class AppPokedex : Application() {
    // Declara a classe AppPokedex, que estende a classe Application do Android.

    override fun onCreate() {
        // Sobrescreve o método onCreate() da classe Application para executar o código de inicialização do aplicativo.

        super.onCreate()
        // Chama a implementação do método onCreate() na superclasse para garantir que qualquer inicialização necessária seja executada.

        Timber.plant(Timber.DebugTree())
        // Configura o Timber para usar o DebugTree, que exibe logs de registro no Logcat durante o desenvolvimento.
        // Isso permite o uso de Timber para registrar mensagens de log em várias partes do aplicativo.
    }
}