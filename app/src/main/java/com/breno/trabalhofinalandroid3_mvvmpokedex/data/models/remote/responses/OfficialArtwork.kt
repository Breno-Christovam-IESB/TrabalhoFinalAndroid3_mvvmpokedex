package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class OfficialArtwork( // Declara uma classe de dados
    @SerializedName("front_default") // Anotação que mapeia o nome do campo JSON "front_default" para a propriedade frontDefault
    val frontDefault: String // Propriedade frontDefault do tipo String, representando a URL da arte oficial da frente padrão
)