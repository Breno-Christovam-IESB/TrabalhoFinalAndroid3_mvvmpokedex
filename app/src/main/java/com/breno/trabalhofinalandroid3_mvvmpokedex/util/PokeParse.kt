package com.breno.trabalhofinalandroid3_mvvmpokedex.util

import androidx.compose.ui.graphics.Color // Importa a classe Color do pacote androidx.compose.ui.graphics
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Type // Importa a classe Type do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses.Stat // Importa a classe Stat do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.responses
import com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme.* // Importa todos os objetos definidos no arquivo Theme.kt
import java.util.* // Importa a classe Locale do pacote java.util

// Função que mapeia o tipo de um Pokémon para uma cor correspondente
fun parseTypeToColor(type: Type): Color {
    return when(type.type.name.toLowerCase(Locale.ROOT)) { // Verifica o nome do tipo em minúsculas
        "normal" -> TypeNormal // Se o tipo for "normal", retorna a cor correspondente do arquivo Theme.kt
        "fire" -> TypeFire // Se o tipo for "fire", retorna a cor correspondente do arquivo Theme.kt
        "water" -> TypeWater // Se o tipo for "water", retorna a cor correspondente do arquivo Theme.kt
        "electric" -> TypeElectric // Se o tipo for "electric", retorna a cor correspondente do arquivo Theme.kt
        "grass" -> TypeGrass // Se o tipo for "grass", retorna a cor correspondente do arquivo Theme.kt
        "ice" -> TypeIce // Se o tipo for "ice", retorna a cor correspondente do arquivo Theme.kt
        "fighting" -> TypeFighting // Se o tipo for "fighting", retorna a cor correspondente do arquivo Theme.kt
        "poison" -> TypePoison // Se o tipo for "poison", retorna a cor correspondente do arquivo Theme.kt
        "ground" -> TypeGround // Se o tipo for "ground", retorna a cor correspondente do arquivo Theme.kt
        "flying" -> TypeFlying // Se o tipo for "flying", retorna a cor correspondente do arquivo Theme.kt
        "psychic" -> TypePsychic // Se o tipo for "psychic", retorna a cor correspondente do arquivo Theme.kt
        "bug" -> TypeBug // Se o tipo for "bug", retorna a cor correspondente do arquivo Theme.kt
        "rock" -> TypeRock // Se o tipo for "rock", retorna a cor correspondente do arquivo Theme.kt
        "ghost" -> TypeGhost // Se o tipo for "ghost", retorna a cor correspondente do arquivo Theme.kt
        "dragon" -> TypeDragon // Se o tipo for "dragon", retorna a cor correspondente do arquivo Theme.kt
        "dark" -> TypeDark // Se o tipo for "dark", retorna a cor correspondente do arquivo Theme.kt
        "steel" -> TypeSteel // Se o tipo for "steel", retorna a cor correspondente do arquivo Theme.kt
        "fairy" -> TypeFairy // Se o tipo for "fairy", retorna a cor correspondente do arquivo Theme.kt
        else -> Color.Black // Se o tipo não for encontrado, retorna preto
    }
}

// Função que mapeia uma estatística de um Pokémon para uma cor correspondente
fun parseStatToColor(stat: Stat): Color {
    return when(stat.stat.name.toLowerCase(Locale.ROOT)) { // Verifica o nome da estatística em minúsculas
        "hp" -> HPColor // Se a estatística for "hp", retorna a cor correspondente do arquivo Theme.kt
        "attack" -> AtkColor // Se a estatística for "attack", retorna a cor correspondente do arquivo Theme.kt
        "defense" -> DefColor // Se a estatística for "defense", retorna a cor correspondente do arquivo Theme.kt
        "special-attack" -> SpAtkColor // Se a estatística for "special-attack", retorna a cor correspondente do arquivo Theme.kt
        "special-defense" -> SpDefColor // Se a estatística for "special-defense", retorna a cor correspondente do arquivo Theme.kt
        "speed" -> SpdColor // Se a estatística for "speed", retorna a cor correspondente do arquivo Theme.kt
        else -> Color.White // Se a estatística não for encontrada, retorna branco
    }
}

// Função que mapeia uma estatística de um Pokémon para uma abreviação correspondente
fun parseStatToAbbr(stat: Stat): String {
    return when(stat.stat.name.toLowerCase(Locale.ROOT)) { // Verifica o nome da estatística em minúsculas
        "hp" -> "HP" // Se a estatística for "hp", retorna a abreviação correspondente
        "attack" -> "Atk" // Se a estatística for "attack", retorna a abreviação correspondente
        "defense" -> "Def" // Se a estatística for "defense", retorna a abreviação correspondente
        "special-attack" -> "SpAtk" // Se a estatística for "special-attack", retorna a abreviação correspondente
        "special-defense" -> "SpDef" // Se a estatística for "special-defense", retorna a abreviação correspondente
        "speed" -> "Spd" // Se a estatística for "speed", retorna a abreviação correspondente
        else -> "" // Se a estatística não for encontrada, retorna uma string vazia
    }
}