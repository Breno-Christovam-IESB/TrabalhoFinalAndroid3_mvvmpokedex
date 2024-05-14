package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationIii( // Declara uma classe de dados
    val emerald: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Emerald, // Propriedade emerald do tipo Emerald, representando a resposta para a versão Emerald
    @SerializedName("firered-leafgreen") // Anotação que mapeia o nome do campo JSON "firered-leafgreen" para a propriedade fireredLeafgreen
    val fireredLeafgreen: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.FireredLeafgreen, // Propriedade fireredLeafgreen do tipo FireredLeafgreen, representando a resposta para a versão FireRed/LeafGreen
    @SerializedName("ruby-sapphire") // Anotação que mapeia o nome do campo JSON "ruby-sapphire" para a propriedade rubySapphire
    val rubySapphire: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.RubySapphire // Propriedade rubySapphire do tipo RubySapphire, representando a resposta para a versão Ruby/Sapphire
)