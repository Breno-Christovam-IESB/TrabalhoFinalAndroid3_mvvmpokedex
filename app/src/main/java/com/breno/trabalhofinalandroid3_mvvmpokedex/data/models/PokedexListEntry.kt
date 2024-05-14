package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models

data class PokedexListEntry( // Declara uma classe de dados
    val pokemonName: String, // Propriedade pokemonName do tipo String, representando o nome do Pokémon
    val imageUrl: String, // Propriedade imageUrl do tipo String, representando a URL da imagem do Pokémon
    val number: Int // Propriedade number do tipo Int, representando o número do Pokémon na Pokédex
)