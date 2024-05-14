package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations não necessário aqui mas tem ligação a outros arquivos similares.

data class Type( // Declara uma classe de dados
    val slot: Int, // Propriedade slot do tipo Int, representando a posição do tipo
    val type: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.TypeX // Propriedade type do tipo TypeX, representando o tipo do Pokémon
)