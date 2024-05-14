package com.breno.trabalhofinalandroid3_mvvmpokedex

import android.os.Bundle // Importa a classe Bundle do pacote android.os, necessária para a passagem de dados entre atividades.
import androidx.activity.ComponentActivity // Importa a classe ComponentActivity do pacote androidx.activity, que é a classe base para atividades que usam o androidx.activity.compose.
import androidx.activity.compose.setContent // Importa a função setContent do pacote androidx.activity.compose, que define o conteúdo da atividade como um composable.
import androidx.compose.runtime.remember // Importa a função remember do pacote androidx.compose.runtime, que permite lembrar um valor durante a recomposição do composable.
import androidx.compose.ui.graphics.Color // Importa a classe Color do pacote androidx.compose.ui.graphics, que representa uma cor.
import androidx.navigation.NavType // Importa a classe NavType do pacote androidx.navigation, que define os tipos de argumentos de navegação.
import androidx.navigation.compose.NavHost // Importa o composable NavHost do pacote androidx.navigation.compose, que hospeda destinos de navegação em um aplicativo.
import androidx.navigation.compose.composable // Importa a função composable do pacote androidx.navigation.compose, que define um destino de navegação com um composable associado.
import androidx.navigation.navArgument // Importa a função navArgument do pacote androidx.navigation, que cria um argumento de navegação para passar dados entre destinos.
import androidx.navigation.compose.rememberNavController // Importa a função rememberNavController do pacote androidx.navigation.compose, que cria um NavController que pode ser lembrado durante recomposições.
import com.breno.trabalhofinalandroid3_mvvmpokedex.pokedetail.PokeDetailScreen // Importa o composable PokeDetailScreen do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.pokedetail, que exibe detalhes de um Pokémon.
import com.breno.trabalhofinalandroid3_mvvmpokedex.pokelist.PokeListScreen // Importa o composable PokeListScreen do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.pokelist, que exibe uma lista de Pokémon.
import com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme.JetpackComposePokedexTheme // Importa o tema JetpackComposePokedexTheme do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme, que define o tema global do aplicativo.
import dagger.hilt.android.AndroidEntryPoint // Importa a anotação AndroidEntryPoint do pacote dagger.hilt.android, que indica ao Dagger Hilt para injetar dependências nesta atividade.
import java.util.*// Importa a classe Locale do pacote java.util, que representa um idioma ou região.

@AndroidEntryPoint
// Anotação que informa ao Dagger Hilt para injetar dependências nesta classe de atividade Android.
class MainActivity : ComponentActivity() {
    // Declara a classe MainActivity, que estende a classe ComponentActivity do Android.

    override fun onCreate(savedInstanceState: Bundle?) {
        // Sobrescreve o método onCreate() da classe ComponentActivity para executar o código de inicialização da atividade.

        super.onCreate(savedInstanceState)
        // Chama a implementação do método onCreate() na superclasse para garantir que qualquer inicialização necessária seja executada.

        setContent {
            // Define o conteúdo da atividade como um composable.

            JetpackComposePokedexTheme {
                // Aplica o tema JetpackComposePokedexTheme ao conteúdo da atividade.

                val navController = rememberNavController()
                // Cria um NavController que pode ser lembrado durante recomposições.

                NavHost(
                    navController = navController,
                    startDestination = "poke_list_screen"
                ) {
                    // Define o host de navegação com o NavController e o destino inicial "poke_list_screen".

                    composable("poke_list_screen") {
                        // Define um destino de navegação chamado "poke_list_screen".

                        PokeListScreen(navController = navController)
                        // Exibe o composable PokeListScreen associado a este destino de navegação.
                    }
                    composable(
                        "poke_detail_screen/{dominantColor}/{pokemonName}",
                        arguments = listOf(
                            navArgument("dominantColor") {
                                type = NavType.IntType
                            },
                            navArgument("pokemonName") {
                                type = NavType.StringType
                            }
                        )
                    ) {
                        // Define um destino de navegação chamado "poke_detail_screen" com argumentos.

                        val dominantColor = remember {
                            // Define uma variável para lembrar o valor da cor dominante.
                            val color = it.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            // Define uma variável para lembrar o nome do Pokémon.
                            it.arguments?.getString("pokemonName")
                        }
                        PokeDetailScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName?.toLowerCase(Locale.ROOT) ?: "",
                            navController = navController
                        )
                        // Exibe o composable PokeDetailScreen associado a este destino de navegação, passando a cor dominante e o nome do Pokémon como argumentos.
                    }
                }
            }
        }
    }
}