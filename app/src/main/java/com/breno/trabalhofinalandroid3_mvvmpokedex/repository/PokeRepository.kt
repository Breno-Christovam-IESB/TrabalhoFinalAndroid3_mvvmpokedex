package com.breno.trabalhofinalandroid3_mvvmpokedex.repository

import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.PokeApi // Importa a interface PokeApi do pacote de modelos remotos
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Pokemon // Importa a classe Pokemon do pacote de respostas remotas
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.PokeList // Importa a classe PokeList do pacote de respostas remotas
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Resource // Importa a classe Resource do pacote util
import dagger.hilt.android.scopes.ActivityScoped // Importa a anotação ActivityScoped para uso com Dagger Hilt
import javax.inject.Inject // Importa a anotação Inject para injeção de dependência

@ActivityScoped // Anotação que indica que a classe é vinculada ao ciclo de vida da atividade e gerenciada pelo Hilt
class PokeRepository @Inject constructor(
    private val api: PokeApi // Injeta a dependência do PokeApi no construtor da classe PokeRepository
) {

    // Função assíncrona que busca uma lista de Pokémon com base no limite e no deslocamento
    suspend fun getPokeList(limit: Int, offset: Int): Resource<PokeList> {
        val response = try {
            api.getPokeList(limit, offset) // Tenta obter a lista de Pokémon da API
        } catch(e: Exception) { // Em caso de exceção
            return Resource.Error("An unknown error occurred.") // Retorna um Resource de erro com uma mensagem genérica
        }
        return Resource.Success(response) // Retorna um Resource de sucesso contendo a lista de Pokémon obtida
    }

    // Função assíncrona que busca informações sobre um Pokémon com base em seu nome
    suspend fun getPokeInfo(pokemonName: String): Resource<Pokemon> {
        val response = try {
            api.getPokeInfo(pokemonName) // Tenta obter informações do Pokémon da API
        } catch(e: Exception) { // Em caso de exceção
            return Resource.Error("An unknown error occurred.") // Retorna um Resource de erro com uma mensagem genérica
        }
        return Resource.Success(response) // Retorna um Resource de sucesso contendo as informações do Pokémon obtidas
    }
}