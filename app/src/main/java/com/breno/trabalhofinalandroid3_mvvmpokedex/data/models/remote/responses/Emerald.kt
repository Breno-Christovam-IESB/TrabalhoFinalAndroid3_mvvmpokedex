package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Emerald( // Declara uma classe de dados
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String, // Propriedade frontDefault do tipo String, representando a URL da imagem da frente padrão
    @SerializedName("front_shiny") // Anotação que mapeia o nome do campo JSON "front_shiny" para a propriedade frontShiny
    val frontShiny: String // Propriedade frontShiny do tipo String, representando a URL da imagem da frente brilhante
)