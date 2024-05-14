package com.breno.trabalhofinalandroid3_mvvmpokedex.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape // Importa a classe RoundedCornerShape do pacote de forma do Compose
import androidx.compose.material.Shapes // Importa a classe Shapes do pacote material do Compose
import androidx.compose.ui.unit.dp // Importa a unidade de densidade independente de pixels (Density-independent Pixels) do Compose

// Define um conjunto de formas (Shapes) para a aplicação
val Shapes = Shapes(
    small = RoundedCornerShape(4.dp), // Define a forma para elementos pequenos com cantos arredondados de 4dp
    medium = RoundedCornerShape(4.dp), // Define a forma para elementos médios com cantos arredondados de 4dp
    large = RoundedCornerShape(0.dp) // Define a forma para elementos grandes com cantos não arredondados (cantos retos)
)