package com.example.artistapplication.network

import com.example.artistapplication.model.ArtistModel
import com.example.artistapplication.model.ResultModel
import retrofit2.Response
import retrofit2.http.GET

interface ArtistApiService {

    @GET("search?term=classick&amp;media=music&amp;entity=song&amp;limit=50") //pass the dnd point here
//    suspend fun getAllArtist():Response<ResultModel>
    suspend fun getAllArtist(): ArtistModel

//check if response is successful
}