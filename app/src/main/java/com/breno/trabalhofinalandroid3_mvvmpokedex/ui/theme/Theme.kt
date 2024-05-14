package com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme // Importa a função isSystemInDarkTheme do pacote foundation do Compose
import androidx.compose.material.MaterialTheme // Importa a classe MaterialTheme do pacote material do Compose
import androidx.compose.material.darkColors // Importa a função darkColors do pacote material do Compose
import androidx.compose.material.lightColors // Importa a função lightColors do pacote material do Compose
import androidx.compose.runtime.Composable // Importa a anotação Composable do pacote runtime do Compose
import androidx.compose.ui.graphics.Color // Importa a classe Color do pacote ui.graphics do Compose

// Define uma paleta de cores para o tema escuro
private val DarkColorPalette = darkColors(
    primary = Color.Yellow, // Define a cor primária como amarelo
    background = Color(0xFF101010), // Define a cor de fundo como preto (hexadecimal 0xFF101010)
    onBackground = Color.White, // Define a cor do texto sobre o fundo como branco
    surface = Color(0xFF303030), // Define a cor de superfície como cinza escuro (hexadecimal 0xFF303030)
    onSurface = Color.White // Define a cor do texto sobre a superfície como branco
)

// Define uma paleta de cores para o tema claro
private val LightColorPalette = lightColors(
    primary = Color.Blue, // Define a cor primária como azul
    background = LightBlue, // Define a cor de fundo como LightBlue (definida anteriormente)
    onBackground = Color.Black, // Define a cor do texto sobre o fundo como preto
    surface = Color.White, // Define a cor de superfície como branco
    onSurface = Color.Black // Define a cor do texto sobre a superfície como preto
)

// Composable que define o tema da aplicação
@Composable
fun JetpackComposePokedexTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    // Determina a paleta de cores com base no tema escuro ou claro
    val colors = if (darkTheme) {
        DarkColorPalette // Usa a paleta de cores do tema escuro
    } else {
        LightColorPalette // Usa a paleta de cores do tema claro
    }

    // Aplica o tema Material à aplicação, definindo as cores, tipografia e formas
    MaterialTheme(
        colors = colors, // Define as cores do tema
        typography = Typography, // Define a tipografia do tema (definida em outro lugar)
        shapes = Shapes, // Define as formas do tema (definidas em outro lugar)
        content = content // Define o conteúdo da aplicação
    )
}