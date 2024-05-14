package com.breno.trabalhofinalandroid3_mvvmpokedex.pokedetail

import androidx.compose.animation.core.animateFloatAsState // Importa a função animateFloatAsState do pacote androidx.compose.animation.core
import androidx.compose.animation.core.tween // Importa a função tween do pacote androidx.compose.animation.core
import androidx.compose.foundation.* // Importa os elementos do pacote androidx.compose.foundation
import com.breno.trabalhofinalandroid3_mvvmpokedex.R // Importa o identificador R do pacote com.breno.trabalhofinalandroid3_mvvmpokedex
import androidx.compose.foundation.layout.* // Importa os elementos do pacote androidx.compose.foundation.layout
import androidx.compose.foundation.shape.CircleShape // Importa a forma CircleShape do pacote androidx.compose.foundation.shape
import androidx.compose.foundation.shape.RoundedCornerShape // Importa a forma RoundedCornerShape do pacote androidx.compose.foundation.shape
import androidx.compose.material.CircularProgressIndicator // Importa o indicador de progresso circular do pacote androidx.compose.material
import androidx.compose.material.Icon // Importa o ícone do pacote androidx.compose.material
import androidx.compose.material.MaterialTheme // Importa o tema Material do pacote androidx.compose.material
import androidx.compose.material.Text // Importa o texto do pacote androidx.compose.material
import androidx.compose.material.icons.Icons // Importa os ícones do pacote androidx.compose.material.icons
import androidx.compose.material.icons.filled.ArrowBack // Importa o ícone de voltar do pacote androidx.compose.material.icons.filled
import androidx.compose.runtime.Composable // Importa a anotação Composable do pacote androidx.compose.runtime
import androidx.compose.runtime.mutableStateOf // Importa a função mutableStateOf do pacote androidx.compose.runtime
import androidx.compose.runtime.produceState // Importa a função produceState do pacote androidx.compose.runtime
import androidx.compose.runtime.* // Importa os elementos do pacote androidx.compose.runtime
import androidx.compose.ui.Alignment // Importa a classe Alignment do pacote androidx.compose.ui
import androidx.compose.ui.Modifier // Importa a classe Modifier do pacote androidx.compose.ui
import androidx.compose.ui.draw.clip // Importa a função clip do pacote androidx.compose.ui.draw
import androidx.compose.ui.draw.shadow // Importa a função shadow do pacote androidx.compose.ui.draw
import androidx.compose.ui.graphics.Brush // Importa a classe Brush do pacote androidx.compose.ui.graphics
import androidx.compose.ui.graphics.Color // Importa a classe Color do pacote androidx.compose.ui.graphics
import androidx.compose.ui.graphics.painter.Painter // Importa a classe Painter do pacote androidx.compose.ui.graphics.painter
import androidx.compose.ui.res.painterResource // Importa a função painterResource do pacote androidx.compose.ui.res
import androidx.compose.ui.text.font.FontWeight // Importa a classe FontWeight do pacote androidx.compose.ui.text.font
import androidx.compose.ui.text.style.TextAlign // Importa a classe TextAlign do pacote androidx.compose.ui.text.style
import androidx.compose.ui.unit.Dp // Importa a classe Dp do pacote androidx.compose.ui.unit
import androidx.compose.ui.unit.dp // Importa a função dp do pacote androidx.compose.ui.unit
import androidx.compose.ui.unit.sp // Importa a função sp do pacote androidx.compose.ui.unit
import androidx.hilt.navigation.compose.hiltViewModel // Importa a função hiltViewModel do pacote androidx.hilt.navigation.compose
import androidx.navigation.NavController // Importa a classe NavController do pacote androidx.navigation
import coil.compose.AsyncImage // Importa a função AsyncImage do pacote coil.compose
import androidx.compose.ui.layout.ContentScale // Importa a classe ContentScale do pacote androidx.compose.ui.layout
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Pokemon // Importa a classe Pokemon do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Type // Importa a classe Type do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Resource // Importa a classe Resource do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.util
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.parseStatToAbbr // Importa a função parseStatToAbbr do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.util
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.parseStatToColor // Importa a função parseStatToColor do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.util
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.parseTypeToColor // Importa a função parseTypeToColor do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.util
import java.util.* // Importa os elementos do pacote java.util
import kotlin.math.round // Importa a função round do pacote kotlin.math

@Composable // Anotação que indica que a função é um composable
fun PokeDetailScreen( // Declara uma função
    dominantColor: Color, // Parâmetro dominantColor do tipo Color, representando a cor dominante
    pokemonName: String, // Parâmetro pokemonName do tipo String, representando o nome do Pokémon
    navController: NavController, // Parâmetro navController do tipo NavController, representando o controlador de navegação
    topPadding: Dp = 20.dp, // Parâmetro topPadding do tipo Dp, representando o preenchimento superior padrão
    pokeImageSize: Dp = 200.dp, // Parâmetro pokeImageSize do tipo Dp, representando o tamanho da imagem do Pokémon
    viewModel: PokeDetailViewModel = hiltViewModel() // Parâmetro viewModel do tipo PokeDetailViewModel, representando o viewModel
) {
    val pokeInfo = produceState<Resource<Pokemon>>(initialValue = Resource.Loading()) { // Declara um estado produzido de Resource<Pokemon>
        value = viewModel.getPokeInfo(pokemonName) // Obtém informações do Pokémon usando o viewModel
    }.value // Obtém o valor do estado

    Box(modifier = Modifier // Composição da caixa
        .fillMaxSize() // Preenche o tamanho máximo
        .background(dominantColor) // Define o plano de fundo como a cor dominante
        .padding(bottom = 16.dp) // Adiciona preenchimento na parte inferior
    ) {
        PokeDetailTopSection( // Chama a função PokeDetailTopSection
            navController = navController, // Passa o navController como parâmetro
            modifier = Modifier // Modificador da função
                .fillMaxWidth() // Preenche a largura máxima
                .fillMaxHeight(0.2f) // Preenche 20% da altura máxima
                .align(Alignment.TopCenter) // Alinha ao topo e ao centro
        )
        PokeDetailStateWrapper( // Chama a função PokeDetailStateWrapper
            pokeInfo = pokeInfo, // Passa o pokeInfo como parâmetro
            modifier = Modifier // Modificador da função
                .fillMaxSize() // Preenche o tamanho máximo
                .padding( // Adiciona preenchimento
                    top = topPadding + pokeImageSize / 2f, // Preenche o topo
                    start = 16.dp, // Preenche à esquerda
                    end = 16.dp, // Preenche à direita
                    bottom = 16.dp // Preenche na parte inferior
                )
                .shadow(10.dp, RoundedCornerShape(10.dp)) // Adiciona sombra
                .clip(RoundedCornerShape(10.dp)) // Corta os cantos arredondados
                .background(MaterialTheme.colors.surface) // Define o plano de fundo como a cor de superfície do MaterialTheme
                .padding(16.dp) // Adiciona preenchimento interno
                .align(Alignment.BottomCenter), // Alinha na parte inferior e no centro
            loadingModifier = Modifier // Modificador de carregamento
                .size(100.dp) // Define o tamanho
                .align(Alignment.Center) // Alinha ao centro
                .padding( // Adiciona preenchimento
                    top = topPadding + pokeImageSize / 2f, // Preenche o topo
                    start = 16.dp, // Preenche à esquerda
                    end = 16.dp, // Preenche à direita
                    bottom = 16.dp // Preenche na parte inferior
                )
        )

        Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) { // Composição da caixa
            if(pokeInfo is Resource.Success) { // Verifica se as informações do Pokémon foram carregadas com sucesso
                pokeInfo.data?.sprites?.let { // Obtém os sprites do Pokémon
                    AsyncImage( // Chama a função AsyncImage
                        data = it.frontDefault, // Passa o frontDefault como parâmetro
                        contentDescription = pokeInfo.data.name, // Passa o nome do Pokémon como descrição de conteúdo
                        contentScale = ContentScale.Fit, // Define a escala de conteúdo
                        modifier = Modifier // Modificador da função
                            .size(pokeImageSize) // Define o tamanho da imagem do Pokémon
                            .offset(y = topPadding), // Define o deslocamento vertical
                        fadeIn = true, // Ativa a animação de fade
                        alignment = Alignment.Center, // Alinha ao centro
                    )
                }
            }
        }
    }
}

fun AsyncImage(data: String, contentDescription: String, contentScale: ContentScale, modifier: Modifier, fadeIn: Boolean, alignment: Alignment) {

}

@Composable // Anotação que indica que a função é um composable
fun PokeDetailTopSection( // Declara a função PokeDetailTopSection
    navController: NavController, // Parâmetro navController do tipo NavController, representando o controlador de navegação
    modifier: Modifier = Modifier // Parâmetro modifier do tipo Modifier, representando o modificador
) {
    Box( // Composição da caixa
        contentAlignment = Alignment.TopStart, // Alinha ao topo e à esquerda
        modifier = modifier // Modificador da função
            .background( // Define o plano de fundo
                Brush.verticalGradient( // Gradiente vertical
                    listOf( // Lista de cores
                        Color.Black, // Cor preta
                        Color.Transparent // Cor transparente
                    )
                )
            )
    ) {
        Icon( // Composição do ícone
            imageVector = Icons.Default.ArrowBack, // Ícone de voltar
            contentDescription = null, // Descrição de conteúdo nula
            tint = Color.White, // Cor branca
            modifier = Modifier // Modificador da função
                .size(36.dp) // Define o tamanho
                .offset(16.dp, 16.dp) // Define o deslocamento
                .clickable { // Torna o ícone clicável
                    navController.popBackStack() // Retorna ao destino anterior
                }
        )
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeDetailStateWrapper( // Declara a função PokeDetailStateWrapper
    pokeInfo: Resource<Pokemon>, // Parâmetro pokeInfo do tipo Resource<Pokemon>, representando as informações do Pokémon
    modifier: Modifier = Modifier, // Parâmetro modifier do tipo Modifier, representando o modificador
    loadingModifier: Modifier = Modifier // Parâmetro loadingModifier do tipo Modifier, representando o modificador de carregamento
) {
    when(pokeInfo) { // Estrutura de controle when
        is Resource.Success -> { // Caso pokeInfo seja Resource.Success
            PokeDetailSection( // Chama a função PokeDetailSection
                pokeInfo = pokeInfo.data!!, // Passa as informações do Pokémon como parâmetro
                modifier = modifier // Passa o modificador como parâmetro
                    .offset(y = (-20).dp) // Define o deslocamento vertical
            )
        }
        is Resource.Error -> { // Caso pokeInfo seja Resource.Error
            Text( // Composição do texto
                text = pokeInfo.message!!, // Passa a mensagem de erro como texto
                color = Color.Red, // Cor vermelha
                modifier = modifier // Passa o modificador como parâmetro
            )
        }
        is Resource.Loading -> { // Caso pokeInfo seja Resource.Loading
            CircularProgressIndicator( // Composição do indicador de progresso circular
                color = MaterialTheme.colors.primary, // Cor primária do MaterialTheme
                modifier = loadingModifier // Passa o modificador de carregamento como parâmetro
            )
        }
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeDetailSection( // Declara a função PokeDetailSection
    pokeInfo: Pokemon, // Parâmetro pokeInfo do tipo Pokemon, representando as informações do Pokémon
    modifier: Modifier = Modifier // Parâmetro modifier do tipo Modifier, representando o modificador
) {
    val scrollState = rememberScrollState() // Declara um estado lembrado para a rolagem
    Column( // Composição da coluna
        horizontalAlignment = Alignment.CenterHorizontally, // Alinha ao centro horizontalmente
        modifier = modifier // Modificador da função
            .fillMaxSize() // Preenche o tamanho máximo
            .offset(y = 100.dp) // Define o deslocamento vertical
            .verticalScroll(scrollState) // Adiciona a capacidade de rolar verticalmente
    ) {
        Text( // Composição do texto
            text = "#${pokeInfo.id} ${pokeInfo.name.capitalize(Locale.ROOT)}", // Texto com o número e o nome do Pokémon
            fontWeight = FontWeight.Bold, // Peso da fonte em negrito
            fontSize = 30.sp, // Tamanho da fonte
            textAlign = TextAlign.Center, // Alinhamento central
            color = MaterialTheme.colors.onSurface // Cor do texto
        )
        PokeTypeSection(types = pokeInfo.types) // Chama a função PokeTypeSection passando os tipos do Pokémon
        PokeDetailDataSection( // Chama a função PokeDetailDataSection
            pokeWeight = pokeInfo.weight, // Passa o peso do Pokémon como parâmetro
            pokeHeight = pokeInfo.height // Passa a altura do Pokémon como parâmetro
        )
        PokeBaseStats(pokeInfo = pokeInfo) // Chama a função PokeBaseStats passando as informações do Pokémon
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeTypeSection(types: List<Type>) { // Declara a função PokeTypeSection
    Row( // Composição da linha
        verticalAlignment = Alignment.CenterVertically, // Alinha ao centro verticalmente
        modifier = Modifier // Modificador da função
            .padding(16.dp) // Adiciona preenchimento
    ) {
        for(type in types) { // Loop sobre os tipos do Pokémon
            Box( // Composição da caixa
                contentAlignment = Alignment.Center, // Alinha ao centro
                modifier = Modifier // Modificador da função
                    .weight(1f) // Peso
                    .padding(horizontal = 8.dp) // Adiciona preenchimento horizontal
                    .clip(CircleShape) // Corta os cantos arredondados
                    .background(parseTypeToColor(type)) // Define o plano de fundo com a cor correspondente ao tipo
                    .height(35.dp) // Define a altura
            ) {
                Text( // Composição do texto
                    text = type.type.name.capitalize(Locale.ROOT), // Nome do tipo do Pokémon com a primeira letra maiúscula
                    color = Color.White, // Cor branca do texto
                    fontSize = 18.sp // Tamanho da fonte
                )
            }
        }
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeDetailDataSection( // Declara a função PokeDetailDataSection
    pokeWeight: Int, // Parâmetro pokeWeight do tipo Int, representando o peso do Pokémon
    pokeHeight: Int, // Parâmetro pokeHeight do tipo Int, representando a altura do Pokémon
    sectionHeight: Dp = 80.dp // Parâmetro sectionHeight do tipo Dp, representando a altura da seção
) {
    val pokeWeightInKg = remember { // Declara um estado lembrado para o peso do Pokémon
        round(pokeWeight * 100f) / 1000f // Converte o peso do Pokémon para quilogramas e arredonda para duas casas decimais
    }
    val pokeHeightInMeters = remember { // Declara um estado lembrado para a altura do Pokémon
        round(pokeHeight * 100f) / 1000f // Converte a altura do Pokémon para metros e arredonda para duas casas decimais
    }
    Row( // Composição da linha
        modifier = Modifier // Modificador da função
            .fillMaxWidth() // Preenche a largura máxima
    ) {
        PokeDetailDataItem( // Chama a função PokeDetailDataItem
            dataValue = pokeWeightInKg, // Passa o peso do Pokémon em quilogramas como parâmetro
            dataUnit = "kg", // Passa a unidade como parâmetro
            dataIcon = painterResource(id = R.drawable.ic_weight), // Passa o ícone do peso como parâmetro
            modifier = Modifier.weight(1f) // Define o peso
        )
        Spacer(modifier = Modifier // Adiciona um espaçador
            .size(1.dp, sectionHeight) // Define o tamanho
            .background(Color.LightGray)) // Define a cor de fundo
        PokeDetailDataItem( // Chama a função PokeDetailDataItem
            dataValue = pokeHeightInMeters, // Passa a altura do Pokémon em metros como parâmetro
            dataUnit = "m", // Passa a unidade como parâmetro
            dataIcon = painterResource(id = R.drawable.ic_height), // Passa o ícone da altura como parâmetro
            modifier = Modifier.weight(1f) // Define o peso
        )
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeDetailDataItem( // Declara a função PokeDetailDataItem
    dataValue: Float, // Parâmetro dataValue do tipo Float, representando o valor dos dados
    dataUnit: String, // Parâmetro dataUnit do tipo String, representando a unidade dos dados
    dataIcon: Painter, // Parâmetro dataIcon do tipo Painter, representando o ícone dos dados
    modifier: Modifier = Modifier // Parâmetro modifier do tipo Modifier, representando o modificador
) {
    Column( // Composição da coluna
        horizontalAlignment = Alignment.CenterHorizontally, // Alinha ao centro horizontalmente
        verticalArrangement = Arrangement.Center, // Alinha ao centro verticalmente
        modifier = modifier // Modificador da função
    ) {
        Icon(painter = dataIcon, contentDescription = null, tint = MaterialTheme.colors.onSurface) // Composição do ícone
        Spacer(modifier = Modifier.height(8.dp)) // Adiciona um espaçador
        Text( // Composição do texto
            text = "$dataValue$dataUnit", // Texto com o valor e a unidade
            color = MaterialTheme.colors.onSurface // Cor do texto
        )
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeStat( // Declara a função PokeStat
    statName: String, // Parâmetro statName do tipo String, representando o nome da estatística
    statValue: Int, // Parâmetro statValue do tipo Int, representando o valor da estatística
    statMaxValue: Int, // Parâmetro statMaxValue do tipo Int, representando o valor máximo da estatística
    statColor: Color, // Parâmetro statColor do tipo Color, representando a cor da estatística
    height: Dp = 28.dp, // Parâmetro height do tipo Dp, representando a altura da estatística
    animDuration: Int = 1000, // Parâmetro animDuration do tipo Int, representando a duração da animação
    animDelay: Int = 0 // Parâmetro animDelay do tipo Int, representando o atraso da animação
) {
    var animationPlayed by remember { // Declara uma variável para controlar se a animação foi reproduzida
        mutableStateOf(false) // Define o valor inicial como falso
    }
    val curPercent = animateFloatAsState( // Obtém o valor atual da animação
        targetValue = if(animationPlayed) { // Define o destino da animação com base na reprodução
            statValue / statMaxValue.toFloat() // Calcula a porcentagem do valor da estatística em relação ao valor máximo
        } else 0f, // Define como 0 se a animação não foi reproduzida
        animationSpec = tween( // Especificações da animação
            animDuration, // Duração da animação
            animDelay // Atraso da animação
        )
    )
    LaunchedEffect(key1 = true) { // Efeito lançado quando a animação é reproduzida
        animationPlayed = true // Define que a animação foi reproduzida
    }
    Box( // Composição da caixa
        modifier = Modifier // Modificador da função
            .fillMaxWidth() // Preenche a largura máxima
            .height(height) // Define a altura
            .clip(CircleShape) // Corta os cantos arredondados
            .background( // Define o plano de fundo
                if (isSystemInDarkTheme()) { // Verifica se está no tema escuro
                    Color(0xFF505050) // Define a cor de fundo como cinza escuro
                } else { // Caso contrário
                    Color.LightGray // Define a cor de fundo como cinza claro
                }
            )
    ) {
        Row( // Composição da linha
            horizontalArrangement = Arrangement.SpaceBetween, // Alinha ao centro horizontalmente
            verticalAlignment = Alignment.CenterVertically, // Alinha ao centro verticalmente
            modifier = Modifier // Modificador da função
                .fillMaxHeight() // Preenche a altura máxima
                .fillMaxWidth(curPercent.value) // Preenche a largura com base na porcentagem atual da animação
                .clip(CircleShape) // Corta os cantos arredondados
                .background(statColor) // Define o plano de fundo com a cor da estatística
                .padding(horizontal = 8.dp) // Adiciona preenchimento horizontal
        ) {
            Text( // Composição do texto
                text = statName, // Nome da estatística
                fontWeight = FontWeight.Bold // Peso da fonte em negrito
            )
            Text( // Composição do texto
                text = (curPercent.value * statMaxValue).toInt().toString(), // Valor atual da estatística
                fontWeight = FontWeight.Bold // Peso da fonte em negrito
            )
        }
    }
}

@Composable // Anotação que indica que a função é um composable
fun PokeBaseStats( // Declara a função PokeBaseStats
    pokeInfo: Pokemon, // Parâmetro pokeInfo do tipo Pokemon, representando as informações do Pokémon
    animDelayPerItem: Int = 100 // Parâmetro animDelayPerItem do tipo Int, representando o atraso da animação por item
) {
    val maxBaseStat = remember { // Declara um estado lembrado para o valor máximo da estatística base
        pokeInfo.stats.maxOf { it.baseStat } // Obtém o valor máximo da estatística base
    }
    Column( // Composição da coluna
        modifier = Modifier.fillMaxWidth() // Preenche a largura máxima
    ) {
        Text( // Composição do texto
            text = "Base stats:", // Texto com o título
            fontSize = 20.sp, // Tamanho da fonte
            color = MaterialTheme.colors.onSurface // Cor do texto
        )
        Spacer(modifier = Modifier.height(4.dp)) // Adiciona um espaçador
        for(i in pokeInfo.stats.indices) { // Loop sobre as estatísticas do Pokémon
            val stat = pokeInfo.stats[i] // Obtém a estatística atual
            PokeStat( // Chama a função PokeStat
                statName = parseStatToAbbr(stat), // Passa o nome abreviado da estatística como parâmetro
                statValue = stat.baseStat, // Passa o valor da estatística como parâmetro
                statMaxValue = maxBaseStat, // Passa o valor máximo da estatística como parâmetro
                statColor = parseStatToColor(stat), // Passa a cor da estatística como parâmetro
                animDelay = i * animDelayPerItem // Passa o atraso da animação como parâmetro
            )
            Spacer(modifier = Modifier.height(8.dp)) // Adiciona um espaçador
        }
    }
}