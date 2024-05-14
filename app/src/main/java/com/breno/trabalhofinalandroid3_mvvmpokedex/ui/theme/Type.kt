package com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme

import androidx.compose.material.Typography // Importa a classe Typography do pacote material do Compose
import androidx.compose.ui.text.TextStyle // Importa a classe TextStyle do pacote ui.text do Compose
import androidx.compose.ui.text.font.Font // Importa a classe Font do pacote ui.text.font do Compose
import androidx.compose.ui.text.font.FontFamily // Importa a classe FontFamily do pacote ui.text.font do Compose
import androidx.compose.ui.text.font.FontWeight // Importa a classe FontWeight do pacote ui.text.font do Compose
import androidx.compose.ui.unit.sp // Importa a unidade de medida sp (escala de pixels) do pacote ui.unit do Compose
import com.breno.trabalhofinalandroid3_mvvmpokedex.R // Importa o recurso R do pacote da aplicação

// Define a família de fontes Roboto com diferentes estilos
val Roboto = FontFamily(
        Font(R.font.roboto_light, FontWeight.Light), // Define a fonte Roboto Light
        Font(R.font.roboto_regular, FontWeight.Normal), // Define a fonte Roboto Regular
        Font(R.font.roboto_medium, FontWeight.Medium), // Define a fonte Roboto Medium
        Font(R.font.roboto_bold, FontWeight.Bold) // Define a fonte Roboto Bold
)

// Define a família de fontes Roboto Condensed com diferentes estilos
val RobotoCondensed = FontFamily(
        Font(R.font.roboto_condensed_light, FontWeight.Light), // Define a fonte Roboto Condensed Light
        Font(R.font.roboto_condensed_regular, FontWeight.Normal) // Define a fonte Roboto Condensed Regular
)

// Define a tipografia para o tema
val Typography = Typography(
        body1 = TextStyle( // Define o estilo para o corpo de texto 1
                fontFamily = Roboto, // Define a família de fontes como Roboto
                fontWeight = FontWeight.Normal, // Define o peso da fonte como normal
                fontSize = 16.sp // Define o tamanho da fonte como 16 sp
        ),

        button = TextStyle( // Define o estilo para os botões
                fontFamily = FontFamily.Default, // Define a família de fontes padrão
                fontWeight = FontWeight.W500, // Define o peso da fonte como 500 (meio)
                fontSize = 14.sp // Define o tamanho da fonte como 14 sp
        ),
        caption = TextStyle( // Define o estilo para legendas
                fontFamily = FontFamily.Default, // Define a família de fontes padrão
                fontWeight = FontWeight.Normal, // Define o peso da fonte como normal
                fontSize = 12.sp // Define o tamanho da fonte como 12 sp
        )
)