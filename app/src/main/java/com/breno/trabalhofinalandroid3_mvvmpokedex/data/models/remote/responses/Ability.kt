package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Ability( // Declara uma classe de dados
    val ability: AbilityX, // Propriedade ability do tipo AbilityX, representando a habilidade
    @SerializedName("is_hidden") // Mapeia o nome do campo JSON "is_hidden" para a propriedade isHidden
    val isHidden: Boolean, // Propriedade booleana que indica se a habilidade está oculta ou não
    val slot: Int // Propriedade slot do tipo Int, indica a posição da habilidade na lista de habilidades de um personagem
)