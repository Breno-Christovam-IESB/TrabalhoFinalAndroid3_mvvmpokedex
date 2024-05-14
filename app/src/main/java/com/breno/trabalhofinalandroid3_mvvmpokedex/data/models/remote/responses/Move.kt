package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Move( // Declara uma classe de dados
    val move: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.MoveX, // Propriedade move do tipo MoveX, representando o movimento
    @SerializedName("version_group_details") // Anotação que mapeia o nome do campo JSON "version_group_details" para a propriedade versionGroupDetails
    val versionGroupDetails: List<com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.VersionGroupDetail> // Propriedade versionGroupDetails do tipo List<VersionGroupDetail>, representando os detalhes do grupo de versões
)