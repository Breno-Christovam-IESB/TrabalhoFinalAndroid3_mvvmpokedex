package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationIv( // Declara uma classe de dados
    @SerializedName("diamond-pearl") // Anotação que mapeia o nome do campo JSON "diamond-pearl" para a propriedade diamondPearl
    val diamondPearl: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.DiamondPearl, // Propriedade diamondPearl do tipo DiamondPearl, representando a resposta para a versão Diamond/Pearl
    @SerializedName("heartgold-soulsilver") // Anotação que mapeia o nome do campo JSON "heartgold-soulsilver" para a propriedade heartgoldSoulsilver
    val heartgoldSoulsilver: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.HeartgoldSoulsilver, // Propriedade heartgoldSoulsilver do tipo HeartgoldSoulsilver, representando a resposta para a versão HeartGold/SoulSilver
    val platinum: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Platinum // Propriedade platinum do tipo Platinum, representando a resposta para a versão Platinum
)