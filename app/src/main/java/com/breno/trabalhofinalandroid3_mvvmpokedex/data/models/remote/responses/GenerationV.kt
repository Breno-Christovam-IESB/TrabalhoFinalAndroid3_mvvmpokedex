package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationV( // Declara uma classe de dados
    @SerializedName("black-white") // Anotação que mapeia o nome do campo JSON "black-white" para a propriedade blackWhite
    val blackWhite: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.BlackWhite // Propriedade blackWhite do tipo BlackWhite, representando a resposta para a versão Black/White
)