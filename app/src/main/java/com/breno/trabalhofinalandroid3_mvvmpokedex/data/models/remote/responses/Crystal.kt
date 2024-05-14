package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Crystal( // Declara uma classe de dados
    @SerializedName("back_default") // Anotação que mapeia o nome do campo JSON "back_default" para a propriedade backDefault
    val backDefault: String, // Propriedade backDefault do tipo String, representando a URL da imagem das costas padrão
    @SerializedName("back_shiny") // Anotação que mapeia o nome do campo JSON "back_shiny" para a propriedade backShiny
    val backShiny: String, // Propriedade backShiny do tipo String, representando a URL da imagem das costas brilhante
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String, // Propriedade frontDefault do tipo String, representando a URL da imagem da frente padrão
    @SerializedName("front_shiny") // Anotação que mapeia o nome do campo JSON "front_shiny" para a propriedade frontShiny
    val frontShiny: String // Propriedade frontShiny do tipo String, representando a URL da imagem da frente brilhante
)