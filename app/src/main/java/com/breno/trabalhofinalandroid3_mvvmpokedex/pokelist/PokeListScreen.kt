package com.breno.trabalhofinalandroid3_mvvmpokedex.pokelist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusState
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.Alignment
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import coil.compose.rememberImagePainter
import androidx.compose.animation.Crossfade
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.request.ImageRequest
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.breno.trabalhofinalandroid3_mvvmpokedex.R
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.PokedexListEntry
import com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme.RobotoCondensed
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Pokemon
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Constants.BASE_URL

@Composable // Define uma função composable, permitindo sua utilização na construção de interfaces no Jetpack Compose
fun PokeListScreen( // Define uma função composable chamada PokeListScreen
    navController: NavController, // Parâmetro navController do tipo NavController
    viewModel: PokeListViewModel = hiltViewModel() // Parâmetro viewModel do tipo PokeListViewModel, com valor padrão sendo uma instância obtida através de hiltViewModel
) {
    Surface( // Renderiza uma superfície na tela
        color = MaterialTheme.colors.background, // Define a cor de fundo como a cor de fundo do tema Material
        modifier = Modifier.fillMaxSize() // Define o tamanho da superfície como preenchendo toda a tela
    ) {
        Column { // Define uma coluna de conteúdo
            Spacer(modifier = Modifier.height(20.dp)) // Adiciona um espaço vazio com altura de 20dp
            Image( // Renderiza uma imagem
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo), // Define o recurso de pintura como o logo do Pokémon internacional
                contentDescription = "Pokemon", // Descrição do conteúdo da imagem
                modifier = Modifier // Modificador aplicado à imagem
                    .fillMaxWidth() // Define a largura da imagem como preenchendo toda a largura disponível
                    .align(CenterHorizontally) // Alinha a imagem ao centro horizontalmente na coluna
            )
            SearchBar( // Renderiza a barra de pesquisa
                hint = "Search...", // Dica de texto para a barra de pesquisa
                modifier = Modifier // Modificador aplicado à barra de pesquisa
                    .fillMaxWidth() // Define a largura da barra de pesquisa como preenchendo toda a largura disponível
                    .padding(16.dp) // Adiciona preenchimento ao redor da barra de pesquisa
            ) {
                viewModel.searchPokeList(it) // Chama a função searchPokeList do viewModel quando ocorre uma mudança na pesquisa
            }
            Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaço vazio com altura de 16dp
            PokeList(navController = navController) // Renderiza a lista de Pokémon
        }
    }
}

@Composable // Define uma função composable
fun SearchBar( // Define uma função chamada SearchBar
    modifier: Modifier = Modifier, // Parâmetro modifier do tipo Modifier, com valor padrão sendo um novo Modifier
    hint: String = "", // Parâmetro hint do tipo String, com valor padrão sendo uma string vazia
    onSearch: (String) -> Unit = {} // Parâmetro onSearch do tipo função que recebe uma string como entrada e não retorna nada, com valor padrão sendo uma função vazia
) {
    var text by remember { // Define uma variável de estado com a função remember, que mantém seu estado entre recomposições
        mutableStateOf("") // Inicializa o valor da variável como uma string vazia
    }
    var isHintDisplayed by remember { // Define uma variável de estado para controlar se a dica está sendo exibida
        mutableStateOf(hint != "") // Inicializa o valor da variável com base no parâmetro hint
    }

    Box(modifier = modifier) { // Renderiza uma caixa com o modificador fornecido
        BasicTextField( // Renderiza um campo de texto básico
            value = text, // Define o valor do campo de texto como a variável text
            onValueChange = { // Define uma ação a ser executada quando o valor do campo de texto é alterado
                text = it // Atualiza o valor da variável text para refletir a mudança no campo de texto
                onSearch(it) // Chama a função onSearch com o novo valor do campo de texto
            },
            maxLines = 1, // Define o número máximo de linhas como 1
            singleLine = true, // Define o campo de texto como de uma única linha
            textStyle = TextStyle(color = Color.Black), // Define o estilo do texto como preto
            modifier = Modifier // Aplica modificações ao campo de texto
                .fillMaxWidth() // Define a largura do campo de texto como preenchendo toda a largura disponível
                .shadow(5.dp, CircleShape) // Adiciona uma sombra ao redor do campo de texto
                .background(Color.White, CircleShape) // Define o fundo do campo de texto como branco com cantos arredondados
                .padding(horizontal = 20.dp, vertical = 12.dp) // Adiciona preenchimento ao redor do campo de texto
                .onFocusChanged { // Define uma ação a ser executada quando o foco do campo de texto é alterado
                    isHintDisplayed = !it.isFocused && text.isEmpty() // Atualiza o estado de exibição da dica com base no foco do campo de texto e no conteúdo atual
                }
        )
        if(isHintDisplayed) { // Verifica se a dica deve ser exibida
            Text( // Renderiza um texto
                text = hint, // Define o texto como a dica fornecida
                color = Color.LightGray, // Define a cor do texto como cinza claro
                modifier = Modifier // Aplica modificações ao texto
                    .padding(horizontal = 20.dp, vertical = 12.dp) // Adiciona preenchimento ao redor do texto
            )
        }
    }
}

@Composable // Define uma função composable
fun PokeList( // Define uma função chamada PokeList
    navController: NavController, // Parâmetro navController do tipo NavController
    viewModel: PokeListViewModel = hiltViewModel() // Parâmetro viewModel do tipo PokeListViewModel, com valor padrão sendo uma instância obtida através de hiltViewModel
) {
    val pokeList by remember { viewModel.pokeList } // Obtém a lista de Pokémon do viewModel e mantém seu estado entre recomposições
    val endReached by remember { viewModel.endReached } // Obtém o estado indicando se o final da lista foi alcançado do viewModel e mantém seu estado entre recomposições
    val loadError by remember { viewModel.loadError } // Obtém a mensagem de erro do viewModel e mantém seu estado entre recomposições
    val isLoading by remember { viewModel.isLoading } // Obtém o estado indicando se a lista está sendo carregada do viewModel e mantém seu estado entre recomposições
    val isSearching by remember { viewModel.isSearching } // Obtém o estado indicando se a pesquisa está em andamento do viewModel e mantém seu estado entre recomposições

    LazyColumn(contentPadding = PaddingValues(16.dp)) { // Renderiza uma coluna com itens preguiçosamente carregados e com preenchimento ao redor
        val itemCount = if(pokeList.size % 2 == 0) { // Calcula o número de itens na lista
            pokeList.size / 2
        } else {
            pokeList.size / 2 + 1
        }
        items(itemCount) { // Renderiza itens com base no número de itens calculado
            if(it >= itemCount - 1 && !endReached && !isLoading && !isSearching) { // Verifica se é necessário carregar mais itens
                LaunchedEffect(key1 = true) { // Cria um efeito lançado quando o carregamento é iniciado
                    viewModel.loadPokePaginated() // Chama a função loadPokePaginated do viewModel para carregar mais itens
                }
            }
            PokedexRow(rowIndex = it, entries = pokeList, navController = navController) // Renderiza uma linha da Pokédex
        }
    }

    Box( // Renderiza uma caixa
        contentAlignment = Center, // Alinha o conteúdo ao centro da caixa
        modifier = Modifier.fillMaxSize() // Define o tamanho da caixa como preenchendo toda a tela
    ) {
        if(isLoading) { // Verifica se a lista está sendo carregada
            CircularProgressIndicator(color = MaterialTheme.colors.primary) // Renderiza um indicador de progresso circular
        }
        if(loadError.isNotEmpty()) { // Verifica se ocorreu um erro no carregamento da lista
            RetrySection(error = loadError) { // Renderiza uma seção de tentativa novamente com a mensagem de erro
                viewModel.loadPokePaginated() // Chama a função loadPokePaginated do viewModel ao tentar novamente
            }
        }
    }
}

@Composable // Esta função é um composable, o que significa que ela pode ser usada para construir interfaces do usuário no Jetpack Compose.
fun PokedexEntry( // Declara a função PokedexEntry que recebe quatro parâmetros: entry, navController, modifier e viewModel.
    entry: PokedexListEntry, // Parâmetro representando uma entrada na Pokédex.
    navController: NavController, // Parâmetro usado para navegação entre telas.
    modifier: Modifier = Modifier, // Parâmetro que define modificações de layout e estilo para o elemento.
    viewModel: PokeListViewModel = hiltViewModel() // Parâmetro que representa o ViewModel usado na tela.
) {
    val defaultDominantColor = MaterialTheme.colors.surface // Cor padrão utilizada se a cor dominante não puder ser calculada.
    var dominantColor by remember { // Variável que mantém o estado da cor dominante da imagem.
        mutableStateOf(defaultDominantColor) // Inicializa a cor dominante com a cor padrão.
    }

    Box( // Componente Box usado para agrupar e organizar outros elementos.
        contentAlignment = Center, // Alinha o conteúdo dentro da Box no centro.
        modifier = modifier // Aplica modificações de layout ao Box.
            .shadow(5.dp, RoundedCornerShape(10.dp)) // Adiciona uma sombra ao Box.
            .clip(RoundedCornerShape(10.dp)) // Define cantos arredondados para o Box.
            .aspectRatio(1f) // Define a proporção de aspecto do Box como 1:1.
            .background( // Define o plano de fundo do Box com um gradiente vertical.
                Brush.verticalGradient(
                    listOf(
                        dominantColor, // Cor dominante da imagem.
                        defaultDominantColor // Cor padrão.
                    )
                )
            )
            .clickable { // Torna o Box clicável para navegar para a tela de detalhes.
                navController.navigate(
                    "poke_detail_screen/${dominantColor.toArgb()}/${entry.pokemonName}"
                )
            }
    ) {
        Column { // Componente Column usado para organizar elementos na vertical.
            CoilImage( // Componente CoilImage usado para carregar e exibir imagens.
                request = ImageRequest.Builder(LocalContext.current) // Constrói uma solicitação de imagem.
                    .data(entry.imageUrl) // Define a URL da imagem a ser carregada.
                    .target { // Define um callback para receber a imagem carregada.
                        viewModel.calcDominantColor(it) { color ->
                            dominantColor = color // Atualiza a cor dominante quando a imagem é carregada.
                        }
                    }
                    .build(),
                contentDescription = entry.pokemonName, // Descrição da imagem para acessibilidade.
                fadeIn = true, // Habilita o efeito de fade ao carregar a imagem.
                modifier = Modifier // Aplica modificações de layout ao CoilImage.
                    .size(120.dp) // Define o tamanho da imagem.
                    .align(CenterHorizontally) // Alinha a imagem no centro horizontalmente.
            ) {
                CircularProgressIndicator( // Exibe um indicador de progresso enquanto a imagem está sendo carregada.
                    color = MaterialTheme.colors.primary, // Cor do indicador de progresso.
                    modifier = Modifier.scale(0.5f) // Escala o tamanho do indicador de progresso.
                )
            }
            Text( // Componente Text usado para exibir o nome do Pokémon.
                text = entry.pokemonName, // Texto a ser exibido.
                fontFamily = RobotoCondensed, // Fonte do texto.
                fontSize = 20.sp, // Tamanho da fonte.
                textAlign = TextAlign.Center, // Alinhamento do texto no centro.
                modifier = Modifier.fillMaxWidth() // Expande o texto para ocupar toda a largura disponível.
            )
        }
    }
}

@Composable
fun CoilImage(request: ImageRequest, contentDescription: String, fadeIn: Boolean, modifier: Modifier, content: @Composable () -> Unit) {

}

@Composable // Define uma função composable
fun PokedexRow( // Define uma função chamada PokedexRow
    rowIndex: Int, // Parâmetro rowIndex do tipo Int
    entries: List<PokedexListEntry>, // Parâmetro entries do tipo List<PokedexListEntry>
    navController: NavController // Parâmetro navController do tipo NavController
) {
    Column { // Define uma coluna de conteúdo
        Row { // Define uma linha de conteúdo
            PokedexEntry( // Renderiza a entrada da Pokédex para o Pokémon na primeira coluna
                entry = entries[rowIndex * 2], // Define a entrada como o Pokémon na posição atual da primeira coluna
                navController = navController, // Passa o NavController para a entrada da Pokédex
                modifier = Modifier.weight(1f) // Define o peso da entrada como 1
            )
            Spacer(modifier = Modifier.width(16.dp)) // Adiciona um espaço vazio com largura de 16dp
            if(entries.size >= rowIndex * 2 + 2) { // Verifica se há um Pokémon na segunda coluna
                PokedexEntry( // Renderiza a entrada da Pokédex para o Pokémon na segunda coluna
                    entry = entries[rowIndex * 2 + 1], // Define a entrada como o Pokémon na posição atual da segunda coluna
                    navController = navController, // Passa o NavController para a entrada da Pokédex
                    modifier = Modifier.weight(1f) // Define o peso da entrada como 1
                )
            } else { // Se não houver um Pokémon na segunda coluna
                Spacer(modifier = Modifier.weight(1f)) // Adiciona um espaço vazio com peso de 1
            }
        }
        Spacer(modifier = Modifier.height(16.dp)) // Adiciona um espaço vazio com altura de 16dp
    }
}

@Composable // Define uma função composable
fun RetrySection( // Define uma função chamada RetrySection
    error: String, // Parâmetro error do tipo String
    onRetry: () -> Unit // Parâmetro onRetry do tipo função que não recebe argumentos e não retorna nada
) {
    Column { // Define uma coluna de conteúdo
        Text(error, color = Color.Red, fontSize = 18.sp) // Renderiza um texto com a mensagem de erro e a cor vermelha
        Spacer(modifier = Modifier.height(8.dp)) // Adiciona um espaço vazio com altura de 8dp
        Button( // Renderiza um botão
            onClick = { onRetry() }, // Define a ação a ser executada quando o botão é clicado
            modifier = Modifier.align(CenterHorizontally) // Alinha o botão ao centro horizontalmente
        ) {
            Text(text = "Retry") // Renderiza um texto no botão
        }
    }
}