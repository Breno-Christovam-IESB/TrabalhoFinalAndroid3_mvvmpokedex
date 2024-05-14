package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationI( // Declara uma classe de dados
    @SerializedName("red-blue") // Anotação que mapeia o nome do campo JSON "red-blue" para a propriedade redBlue
    val redBlue: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.RedBlue, // Propriedade redBlue do tipo RedBlue, representando a resposta para a versão Red/Blue
    val yellow: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Yellow // Propriedade yellow do tipo Yellow, representando a resposta para a versão Yellow
)