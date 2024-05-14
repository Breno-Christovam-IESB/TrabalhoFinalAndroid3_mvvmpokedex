package com.breno.trabalhofinalandroid3_mvvmpokedex.util

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    // Define uma classe selada Resource com um tipo genérico T
    // A classe tem dois parâmetros opcionais: data (do tipo T) e message (do tipo String)

    class Success<T>(data: T) : Resource<T>(data)
    // Define uma subclasse Success da classe Resource, parametrizada com o tipo T
    // Quando instanciada, recebe um dado do tipo T e passa para o construtor da superclasse

    class Error<T>(message: String, data: T? = null) : Resource<T>(data, message)
    // Define uma subclasse Error da classe Resource, parametrizada com o tipo T
    // Quando instanciada, recebe uma mensagem de erro e opcionalmente um dado do tipo T, e passa para o construtor da superclasse

    class Loading<T> : Resource<T>()
    // Define uma subclasse Loading da classe Resource, parametrizada com o tipo T
    // Não recebe nenhum parâmetro, apenas invoca o construtor da superclasse
}