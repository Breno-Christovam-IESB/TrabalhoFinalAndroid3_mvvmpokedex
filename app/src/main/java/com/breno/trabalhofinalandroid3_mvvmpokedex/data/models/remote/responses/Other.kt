package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Other( // Declara uma classe de dados
    @SerializedName("dream_world") // Anotação que mapeia o nome do campo JSON "dream_world" para a propriedade dreamWorld
    val dreamWorld: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.DreamWorld, // Propriedade dreamWorld do tipo DreamWorld, representando a resposta para o mundo dos sonhos
    @SerializedName("official-artwork") // Anotação que mapeia o nome do campo JSON "official-artwork" para a propriedade officialArtwork
    val officialArtwork: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.OfficialArtwork // Propriedade officialArtwork do tipo OfficialArtwork, representando a resposta para a arte oficial
)