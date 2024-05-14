package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class VersionGroupDetail( // Declara uma classe de dados
    @SerializedName("level_learned_at") // Anotação que mapeia o nome do campo JSON "level_learned_at" para a propriedade levelLearnedAt
    val levelLearnedAt: Int, // Propriedade levelLearnedAt do tipo Int, representando o nível em que o movimento é aprendido
    @SerializedName("move_learn_method") // Anotação que mapeia o nome do campo JSON "move_learn_method" para a propriedade moveLearnMethod
    val moveLearnMethod: MoveLearnMethod, // Propriedade moveLearnMethod do tipo MoveLearnMethod, representando o método de aprendizagem do movimento
    @SerializedName("version_group") // Anotação que mapeia o nome do campo JSON "version_group" para a propriedade versionGroup
    val versionGroup: VersionGroup // Propriedade versionGroup do tipo VersionGroup, representando o grupo de versões em que o movimento é aprendido
)