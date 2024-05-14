package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GameIndice( // Declara uma classe de dados
    @SerializedName("game_index") // Anotação que mapeia o nome do campo JSON "game_index" para a propriedade gameIndex
    val gameIndex: Int, // Propriedade gameIndex do tipo Int, representando o índice do jogo
    val version: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Version // Propriedade version do tipo Version, representando a versão do jogo
)