package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class DreamWorld( // Declara uma classe de dados
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String, // Propriedade frontDefault do tipo String, representando a URL da imagem da frente padrão
    @SerializedName("front_female") // Anotação que mapeia o nome do campo JSON "front_female" para a propriedade frontFemale
    val frontFemale: Any // Propriedade frontFemale de tipo Any, representando a imagem da frente feminina (qualquer tipo pode ser retornado)
)