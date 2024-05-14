package com.breno.trabalhofinalandroid3_mvvmpokedex.pokelist

import android.graphics.Bitmap // Importa a classe Bitmap para manipulação de imagens
import android.graphics.drawable.BitmapDrawable // Importa a classe BitmapDrawable para desenhos baseados em bitmaps
import android.graphics.drawable.Drawable // Importa a classe Drawable para manipulação de imagens desenháveis
import androidx.compose.runtime.mutableStateOf // Importa a função mutableStateOf para criar estados mutáveis
import androidx.compose.ui.graphics.Color // Importa a classe Color para manipulação de cores
import androidx.lifecycle.ViewModel // Importa a classe ViewModel do Android Architecture Components
import androidx.lifecycle.viewModelScope // Importa viewModelScope para lançar corrotinas relacionadas ao ciclo de vida do ViewModel
import androidx.palette.graphics.Palette // Importa a classe Palette para extração de cores dominantes de uma imagem
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.PokedexListEntry // Importa a classe PokedexListEntry do pacote de modelos de dados
import com.breno.trabalhofinalandroid3_mvvmpokedex.repository.PokeRepository // Importa a classe PokeRepository para acessar os dados da API
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Constants.PAGE_SIZE // Importa a constante PAGE_SIZE do objeto Constants
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Resource // Importa a classe Resource para encapsular dados de carregamento
import dagger.hilt.android.lifecycle.HiltViewModel // Importa a anotação HiltViewModel do Dagger Hilt
import kotlinx.coroutines.Dispatchers // Importa Dispatchers para especificar o contexto da corrotina
import kotlinx.coroutines.launch // Importa launch para iniciar uma nova corrotina
import java.util.* // Importa a classe utilitária java.util.* para manipulação de tempo e outras funcionalidades
import javax.inject.Inject // Importa a anotação Inject do Dagger Hilt para a injeção de dependências

@HiltViewModel // Anotação para indicar que esta classe é um ViewModel e deve ser gerenciada pelo Hilt
class PokeListViewModel @Inject constructor( // Declaração da classe PokeListViewModel, injetando o PokeRepository
    private val repository: PokeRepository // Parâmetro para a injeção do repositório
) : ViewModel() { // Herda da classe ViewModel do Android Architecture Components

    private var curPage = 0 // Variável que rastreia a página atual da lista de Pokémon

    var pokeList = mutableStateOf<List<PokedexListEntry>>(listOf()) // Estado mutável para armazenar a lista de Pokémon
    var loadError = mutableStateOf("") // Estado mutável para armazenar mensagens de erro de carregamento
    var isLoading = mutableStateOf(false) // Estado mutável para indicar se o carregamento está em andamento
    var endReached = mutableStateOf(false) // Estado mutável para indicar se o final da lista foi alcançado

    private var cachedPokeList = listOf<PokedexListEntry>() // Lista temporária para armazenar a lista de Pokémon em cache
    private var isSearchStarting = true // Variável para indicar se é o início da pesquisa
    var isSearching = mutableStateOf(false) // Estado mutável para indicar se a pesquisa está em andamento

    init { // Inicializador do ViewModel, carrega a lista de Pokémon paginada
        loadPokePaginated()
    }

    fun searchPokeList(query: String) { // Função para pesquisar Pokémon na lista
        val listToSearch = if(isSearchStarting) {
            pokeList.value // Usa a lista atual se for o início da pesquisa
        } else {
            cachedPokeList // Usa a lista em cache se a pesquisa já estiver em andamento
        }
        viewModelScope.launch(Dispatchers.Default) { // Inicia uma nova corrotina no contexto padrão
            if(query.isEmpty()) { // Verifica se a consulta está vazia
                pokeList.value = cachedPokeList // Restaura a lista original
                isSearching.value = false // Indica que a pesquisa foi concluída
                isSearchStarting = true // Marca como o início da pesquisa
                return@launch // Sai da corrotina
            }
            val results = listToSearch.filter { // Filtra os resultados da pesquisa
                it.pokemonName.contains(query.trim(), ignoreCase = true) || // Verifica se o nome do Pokémon contém a consulta
                        it.number.toString() == query.trim() // Verifica se o número do Pokémon corresponde à consulta
            }
            if(isSearchStarting) { // Se for o início da pesquisa
                cachedPokeList = pokeList.value // Armazena a lista original em cache
                isSearchStarting = false // Marca que a pesquisa já começou
            }
            pokeList.value = results // Atualiza a lista de Pokémon com os resultados da pesquisa
            isSearching.value = true // Indica que a pesquisa está em andamento
        }
    }

    fun loadPokePaginated() { // Função para carregar a lista de Pokémon de forma paginada
        viewModelScope.launch { // Inicia uma nova corrotina no escopo do ViewModel
            isLoading.value = true // Indica que o carregamento está em andamento
            val result = repository.getPokeList(PAGE_SIZE, curPage * PAGE_SIZE) // Carrega a lista de Pokémon da API
            when(result) { // Avalia o resultado do carregamento
                is Resource.Success -> { // Se o carregamento for bem-sucedido
                    endReached.value = curPage * PAGE_SIZE >= result.data!!.count // Verifica se o final da lista foi alcançado
                    val pokedexEntries = result.data.results.mapIndexed { index, entry -> // Mapeia os dados da lista de Pokémon
                        val number = if(entry.url.endsWith("/")) { // Extrai o número do Pokémon da URL
                            entry.url.dropLast(1).takeLastWhile { it.isDigit() }
                        } else {
                            entry.url.takeLastWhile { it.isDigit() }
                        }
                        val url = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${number}.png" // URL da imagem do Pokémon
                        PokedexListEntry(entry.name.capitalize(Locale.ROOT), url, number.toInt()) // Cria uma entrada na lista de Pokémon
                    }
                    curPage++ // Incrementa a página atual
                    loadError.value = "" // Limpa a mensagem de erro
                    isLoading.value = false // Indica que o carregamento foi concluído
                    pokeList.value += pokedexEntries // Adiciona os novos Pokémon à lista existente
                }
                is Resource.Error -> { // Se ocorrer um erro durante o carregamento
                    loadError.value = result.message!! // Define a mensagem de erro
                    isLoading.value = false // Indica que o carregamento foi concluído
                }
                else -> { // Se ocorrer outro tipo de resultado
                    loadError.value = "Erro desconhecido" // Define uma mensagem de erro genérica
                    isLoading.value = false // Indica que o carregamento foi concluído
                }
            }
        }
    }

    fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) { // Função para calcular a cor dominante de uma imagem
        val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true) // Converte o Drawable em um Bitmap

        Palette.from(bmp).generate { palette -> // Gera uma paleta de cores a partir do Bitmap
            palette?.dominantSwatch?.rgb?.let { colorValue -> // Obtém a cor dominante da paleta, se disponível
                onFinish(Color(colorValue)) // Chama a função de retorno com a cor dominante
            }
        }
    }
}