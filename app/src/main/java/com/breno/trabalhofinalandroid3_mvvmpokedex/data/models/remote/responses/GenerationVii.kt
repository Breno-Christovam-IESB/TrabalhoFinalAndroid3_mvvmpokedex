package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class GenerationVii( // Declara uma classe de dados
    val icons: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Icons, // Propriedade icons do tipo Icons, representando a resposta para os ícones da geração VII
    @SerializedName("ultra-sun-ultra-moon") // Anotação que mapeia o nome do campo JSON "ultra-sun-ultra-moon" para a propriedade ultraSunUltraMoon
    val ultraSunUltraMoon: com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.UltraSunUltraMoon // Propriedade ultraSunUltraMoon do tipo UltraSunUltraMoon, representando a resposta para a versão Ultra Sun/Ultra Moon
)