package com.breno.trabalhofinalandroid3_mvvmpokedex.pokedetail

import androidx.lifecycle.ViewModel // Importa a classe base ViewModel do Android Jetpack
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Pokemon // Importa a classe Pokemon do pacote de respostas remotas
import com.breno.trabalhofinalandroid3_mvvmpokedex.repository.PokeRepository // Importa o repositório PokeRepository
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Resource // Importa a classe Resource do pacote util
import dagger.hilt.android.lifecycle.HiltViewModel // Importa a anotação HiltViewModel para uso com Dagger Hilt
import javax.inject.Inject // Importa a anotação Inject para injeção de dependência

@HiltViewModel // Anotação que indica que essa classe é um ViewModel gerenciado pelo Hilt
class PokeDetailViewModel @Inject constructor(
    private val repository: PokeRepository // Injeta a dependência do PokeRepository no construtor da classe ViewModel
) : ViewModel() { // Declara a classe PokeDetailViewModel que herda da classe base ViewModel

    // Função assíncrona que busca informações sobre um Pokémon com base em seu nome
    suspend fun getPokeInfo(pokemonName: String): Resource<Pokemon> {
        return repository.getPokeInfo(pokemonName) // Retorna um Resource contendo informações do Pokémon
    }
}