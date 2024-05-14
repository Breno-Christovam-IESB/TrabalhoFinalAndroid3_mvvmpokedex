package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Stat( // Declara uma classe de dados
    @SerializedName("base_stat") // Anotação que mapeia o nome do campo JSON "base_stat" para a propriedade baseStat
    val baseStat: Int, // Propriedade baseStat do tipo Int, representando o valor base da estatística
    val effort: Int, // Propriedade effort do tipo Int, representando o esforço da estatística
    val stat: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.StatX // Propriedade stat do tipo StatX, representando a estatística
)