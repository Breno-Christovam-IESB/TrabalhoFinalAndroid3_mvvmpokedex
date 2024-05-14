package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Yellow( // Declara uma classe de dados
    @SerializedName("back_default") // Anotação que mapeia o nome do campo JSON "back_default" para a propriedade backDefault
    val backDefault: String, // Propriedade backDefault do tipo String, representando a URL da imagem de trás padrão
    @SerializedName("back_gray") // Anotação que mapeia o nome do campo JSON "back_gray" para a propriedade backGray
    val backGray: String, // Propriedade backGray do tipo String, representando a URL da imagem de trás em escala de cinza
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String, // Propriedade frontDefault do tipo String, representando a URL da imagem da frente padrão
    @SerializedName("front_gray") // Anotação que mapeia o nome do campo JSON "front_gray" para a propriedade frontGray
    val frontGray: String // Propriedade frontGray do tipo String, representando a URL da imagem da frente em escala de cinza
)