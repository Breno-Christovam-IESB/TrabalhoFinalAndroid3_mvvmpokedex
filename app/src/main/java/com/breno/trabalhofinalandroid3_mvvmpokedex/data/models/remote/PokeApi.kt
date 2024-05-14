package com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote

import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.PokeList // Importa a classe PokeList do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Pokemon // Importa a classe Pokemon do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import retrofit2.http.GET // Importa a anotação GET do pacote retrofit2.http
import retrofit2.http.Path // Importa a anotação Path do pacote retrofit2.http
import retrofit2.http.Query // Importa a anotação Query do pacote retrofit2.http

interface PokeApi { // Declara uma interface

    @GET("pokemon") // Anotação que indica que o método faz uma requisição GET para o endpoint "pokemon"
    suspend fun getPokeList( // Declaração do método getPokeList
        @Query("limit") limit: Int, // Parâmetro limit do tipo Int, representando o limite de resultados a serem retornados
        @Query("offset") offset: Int // Parâmetro offset do tipo Int, representando o deslocamento da lista de resultados
    ): PokeList // Retorna um objeto do tipo PokeList

    @GET("pokemon/{name}") // Anotação que indica que o método faz uma requisição GET para o endpoint "pokemon/{name}"
    suspend fun getPokeInfo( // Declaração do método getPokeInfo
        @Path("name") name: String // Parâmetro name do tipo String, representando o nome do Pokémon a ser buscado
    ): Pokemon // Retorna um objeto do tipo Pokemon
}