package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class DiamondPearl( // Declara uma classe de dados
    @SerializedName("back_default") // Anotação que mapeia o nome do campo JSON "back_default" para a propriedade backDefault
    val backDefault: String, // Propriedade backDefault do tipo String, representando a URL da imagem das costas padrão
    @SerializedName("back_female") // Anotação que mapeia o nome do campo JSON "back_female" para a propriedade backFemale
    val backFemale: Any, // Propriedade backFemale de tipo Any, representando a imagem das costas feminina (qualquer tipo pode ser retornado)
    @SerializedName("back_shiny") // Anotação que mapeia o nome do campo JSON "back_shiny" para a propriedade backShiny
    val backShiny: String, // Propriedade backShiny do tipo String, representando a URL da imagem das costas brilhante
    @SerializedName("back_shiny_female") // Anotação que mapeia o nome do campo JSON "back_shiny_female" para a propriedade backShinyFemale
    val backShinyFemale: Any, // Propriedade backShinyFemale de tipo Any, representando a imagem das costas brilhante feminina (qualquer tipo pode ser retornado)
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String, // Propriedade frontDefault do tipo String, representando a URL da imagem da frente padrão
    @SerializedName("front_female") // Anotação que mapeia o nome do campo JSON "front_female" para a propriedade frontFemale
    val frontFemale: Any, // Propriedade frontFemale de tipo Any, representando a imagem da frente feminina (qualquer tipo pode ser retornado)
    @SerializedName("front_shiny") // Anotação que mapeia o nome do campo JSON "front_shiny" para a propriedade frontShiny
    val frontShiny: String, // Propriedade frontShiny do tipo String, representando a URL da imagem da frente brilhante
    @SerializedName("front_shiny_female") // Anotação que mapeia o nome do campo JSON "front_shiny_female" para a propriedade frontShinyFemale
    val frontShinyFemale: Any // Propriedade frontShinyFemale de tipo Any, representando a imagem da frente brilhante feminina (qualquer tipo pode ser retornado)
)