package com.breno.trabalhofinalandroid3_mvvmpokedex.di

import com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote.PokeApi // Importa a interface PokeApi do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.data.models.remote
import com.breno.trabalhofinalandroid3_mvvmpokedex.repository.PokeRepository // Importa a classe PokeRepository do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.repository
import com.breno.trabalhofinalandroid3_mvvmpokedex.util.Constants.BASE_URL // Importa a constante BASE_URL do pacote com.breno.trabalhofinalandroid3_mvvmpokedex.util.Constants
import dagger.Module // Importa a anotação Module do pacote dagger
import dagger.Provides // Importa a anotação Provides do pacote dagger
import dagger.hilt.InstallIn // Importa a anotação InstallIn do pacote dagger.hilt
import dagger.hilt.components.SingletonComponent // Importa o componente SingletonComponent do pacote dagger.hilt.components
import retrofit2.Retrofit // Importa a classe Retrofit do pacote retrofit2
import retrofit2.converter.gson.GsonConverterFactory // Importa a classe GsonConverterFactory do pacote retrofit2.converter.gson
import javax.inject.Singleton // Importa a anotação Singleton do pacote javax.inject

@Module // Anotação que indica que a classe é um módulo Dagger
@InstallIn(SingletonComponent::class) // Anotação que indica que este módulo deve ser instalado no componente SingletonComponent
object AppModule { // Declara um objeto

    @Singleton // Anotação que indica que o método deve ser provido como um singleton
    @Provides // Anotação que indica que o método provê uma instância de PokeRepository
    fun providePokeRepository( // Declaração do método providePokeRepository
        api: PokeApi // Parâmetro api do tipo PokeApi, representando a API do Pokémon
    ) = PokeRepository(api) // Retorna uma instância de PokeRepository com a API fornecida como parâmetro

    @Singleton // Anotação que indica que o método deve ser provido como um singleton
    @Provides // Anotação que indica que o método provê uma instância de PokeApi
    fun providePokeApi(): PokeApi { // Declaração do método providePokeApi
        return Retrofit.Builder() // Retorna uma instância de Retrofit.Builder
            .addConverterFactory(GsonConverterFactory.create()) // Adiciona um conversor de JSON para Gson
            .baseUrl(BASE_URL) // Define a URL base para a API
            .build() // Constrói o objeto Retrofit
            .create(PokeApi::class.java) // Cria uma implementação da interface PokeApi
    }
}