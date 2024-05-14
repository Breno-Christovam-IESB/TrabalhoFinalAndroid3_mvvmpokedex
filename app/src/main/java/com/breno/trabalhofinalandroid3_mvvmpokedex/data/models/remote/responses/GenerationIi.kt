package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations não necessário aqui mas tem ligação a outros arquivos similares.

data class GenerationIi( // Declara uma classe de dados
    val crystal: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Crystal, // Propriedade crystal do tipo Crystal, representando a resposta para a versão Crystal
    val gold: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Gold, // Propriedade gold do tipo Gold, representando a resposta para a versão Gold
    val silver: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Silver // Propriedade silver do tipo Silver, representando a resposta para a versão Silver
)