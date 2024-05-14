package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses

import com.google.gson.annotations.SerializedName // Importa a classe SerializedName do pacote com.google.gson.annotations

data class Pokemon( // Declara uma classe de dados
    val abilities: List<Ability>, // Propriedade abilities do tipo List<Ability>, representando as habilidades do Pokémon
    @SerializedName("base_experience") // Anotação que mapeia o nome do campo JSON "base_experience" para a propriedade baseExperience
    val baseExperience: Int, // Propriedade baseExperience do tipo Int, representando a experiência base do Pokémon
    val forms: List<Form>, // Propriedade forms do tipo List<Form>, representando as formas do Pokémon
    @SerializedName("game_indices") // Anotação que mapeia o nome do campo JSON "game_indices" para a propriedade gameIndices
    val gameIndices: List<GameIndice>, // Propriedade gameIndices do tipo List<GameIndice>, representando os índices de jogos do Pokémon
    val height: Int, // Propriedade height do tipo Int, representando a altura do Pokémon
    @SerializedName("held_items") // Anotação que mapeia o nome do campo JSON "held_items" para a propriedade heldItems
    val heldItems: List<Any>, // Propriedade heldItems do tipo List<Any>, representando os itens que o Pokémon está segurando
    val id: Int, // Propriedade id do tipo Int, representando o ID do Pokémon
    @SerializedName("is_default") // Anotação que mapeia o nome do campo JSON "is_default" para a propriedade isDefault
    val isDefault: Boolean, // Propriedade isDefault do tipo Boolean, indicando se o Pokémon é o padrão
    @SerializedName("location_area_encounters") // Anotação que mapeia o nome do campo JSON "location_area_encounters" para a propriedade locationAreaEncounters
    val locationAreaEncounters: String, // Propriedade locationAreaEncounters do tipo String, representando as áreas de encontro do Pokémon
    val moves: List<Move>, // Propriedade moves do tipo List<Move>, representando os movimentos do Pokémon
    val name: String, // Propriedade name do tipo String, representando o nome do Pokémon
    val order: Int, // Propriedade order do tipo Int, representando a ordem do Pokémon
    @SerializedName("past_types") // Anotação que mapeia o nome do campo JSON "past_types" para a propriedade pastTypes
    val pastTypes: List<Any>, // Propriedade pastTypes do tipo List<Any>, representando os tipos passados do Pokémon
    val species: Species, // Propriedade species do tipo Species, representando a espécie do Pokémon
    val sprites: Sprites, // Propriedade sprites do tipo Sprites, representando os sprites do Pokémon
    val stats: List<Stat>, // Propriedade stats do tipo List<Stat>, representando as estatísticas do Pokémon
    val types: List<Type>, // Propriedade types do tipo List<Type>, representando os tipos do Pokémon
    val weight: Int // Propriedade weight do tipo Int, representando o peso do Pokémon
)