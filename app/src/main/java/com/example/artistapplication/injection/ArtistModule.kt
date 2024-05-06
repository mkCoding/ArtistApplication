package com.example.artistapplication.injection

import com.example.artistapplication.network.ArtistApiService
import com.example.artistapplication.repository.ArtistRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class ArtistModule {

    /*
      * ArtistApiService: passed as a param to repository
      * ArtistRepository: passed as a param to viewmodel
     */

    @Singleton
    @Provides
    fun provideApiServiceObject():ArtistApiService=
        Retrofit.Builder()
            .baseUrl("https://itunes.apple.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArtistApiService::class.java)


    @Singleton
    @Provides
    fun provideArtistRepo(): ArtistRepository =
        ArtistRepository(provideApiServiceObject())



}