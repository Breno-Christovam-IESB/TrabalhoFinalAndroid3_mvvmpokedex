package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations não necessário aqui mas tem ligação a outros arquivos similares.

data class GenerationViii( // Declara uma classe de dados
    val icons: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.IconsX // Propriedade icons do tipo IconsX, representando a resposta para os ícones da geração VIII
)