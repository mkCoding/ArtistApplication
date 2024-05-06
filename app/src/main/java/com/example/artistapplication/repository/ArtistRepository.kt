package com.example.artistapplication.repository

import com.example.artistapplication.model.ArtistModel
import com.example.artistapplication.network.ArtistApiService
import javax.inject.Inject

class ArtistRepository @Inject constructor(private val service: ArtistApiService) {
    suspend fun getAllArtist() = service.getAllArtist()
}