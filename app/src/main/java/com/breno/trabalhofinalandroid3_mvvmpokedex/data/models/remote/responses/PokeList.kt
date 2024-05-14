package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations não necessário aqui mas tem ligação a outros arquivos similares.

data class PokeList( // Declara uma classe de dados
    val count: Int, // Propriedade count do tipo Int, representando a contagem total de Pokémons
    val next: String, // Propriedade next do tipo String, representando a URL da próxima página de resultados
    val previous: Any, // Propriedade previous de tipo Any, representando a URL da página anterior de resultados (qualquer tipo pode ser retornado)
    val results: List<Result> // Propriedade results do tipo List<Result>, representando a lista de resultados de Pokémons
)