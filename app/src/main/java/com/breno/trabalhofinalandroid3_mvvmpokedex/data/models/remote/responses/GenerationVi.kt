package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationVi( // Declara uma classe de dados
    @SerializedName("omegaruby-alphasapphire") // Anotação que mapeia o nome do campo JSON "omegaruby-alphasapphire" para a propriedade omegarubyAlphasapphire
    val omegarubyAlphasapphire: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.OmegarubyAlphasapphire, // Propriedade omegarubyAlphasapphire do tipo OmegarubyAlphasapphire, representando a resposta para a versão Omega Ruby/Alpha Sapphire
    @SerializedName("x-y") // Anotação que mapeia o nome do campo JSON "x-y" para a propriedade xY
    val xY: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.XY // Propriedade xY do tipo XY, representando a resposta para a versão X/Y
)