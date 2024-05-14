package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations não necessário aqui mas tem ligação a outros arquivos similares.

data class MoveLearnMethod( // Declara uma classe de dados
    val name: String, // Propriedade name do tipo String, representando o nome do método de aprendizado do movimento
    val url: String // Propriedade url do tipo String, representando a URL relacionada ao método de aprendizado do movimento
)