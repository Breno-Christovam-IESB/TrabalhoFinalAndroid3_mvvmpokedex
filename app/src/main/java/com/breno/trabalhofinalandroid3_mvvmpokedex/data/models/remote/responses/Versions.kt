package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Versions( // Declara uma classe de dados
    @SerializedName("generation-i") // Anotação que mapeia o nome do campo JSON "generation-i" para a propriedade generationI
    val generationI: GenerationI, // Propriedade generationI do tipo GenerationI, representando as versões da geração I
    @SerializedName("generation-ii") // Anotação que mapeia o nome do campo JSON "generation-ii" para a propriedade generationIi
    val generationIi: GenerationIi, // Propriedade generationIi do tipo GenerationIi, representando as versões da geração II
    @SerializedName("generation-iii") // Anotação que mapeia o nome do campo JSON "generation-iii" para a propriedade generationIii
    val generationIii: GenerationIii, // Propriedade generationIii do tipo GenerationIii, representando as versões da geração III
    @SerializedName("generation-iv") // Anotação que mapeia o nome do campo JSON "generation-iv" para a propriedade generationIv
    val generationIv: GenerationIv, // Propriedade generationIv do tipo GenerationIv, representando as versões da geração IV
    @SerializedName("generation-v") // Anotação que mapeia o nome do campo JSON "generation-v" para a propriedade generationV
    val generationV: GenerationV, // Propriedade generationV do tipo GenerationV, representando as versões da geração V
    @SerializedName("generation-vi") // Anotação que mapeia o nome do campo JSON "generation-vi" para a propriedade generationVi
    val generationVi: GenerationVi, // Propriedade generationVi do tipo GenerationVi, representando as versões da geração VI
    @SerializedName("generation-vii") // Anotação que mapeia o nome do campo JSON "generation-vii" para a propriedade generationVii
    val generationVii: GenerationVii, // Propriedade generationVii do tipo GenerationVii, representando as versões da geração VII
    @SerializedName("generation-viii") // Anotação que mapeia o nome do campo JSON "generation-viii" para a propriedade generationViii
    val generationViii: GenerationViii // Propriedade generationViii do tipo GenerationViii, representando as versões da geração VIII
)