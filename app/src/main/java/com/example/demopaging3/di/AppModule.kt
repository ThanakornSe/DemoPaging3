package com.example.demopaging3.di

import com.example.demopaging3.api.UnsplashApi
import com.example.demopaging3.repository.UnsplashRepository
import com.example.demopaging3.repository.UnsplashRepositoryImpl
import com.example.demopaging3.ui.home.HomeFragmentViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppModule {

    private fun retrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(UnsplashApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private fun UnsplashApi(retrofit: Retrofit): UnsplashApi =
        retrofit.create(UnsplashApi::class.java)

    val appModule = module {
        single { retrofit() }
        single { UnsplashApi(get()) }
        single<UnsplashRepository> { UnsplashRepositoryImpl(get()) }
        viewModel { HomeFragmentViewModel(get(),get()) }
    }
}