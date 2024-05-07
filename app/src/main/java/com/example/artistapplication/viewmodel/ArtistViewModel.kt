package com.example.artistapplication.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.artistapplication.model.ArtistModel
import com.example.artistapplication.model.ResultModel
import com.example.artistapplication.repository.ArtistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistViewModel @Inject constructor(private val artistRepository:ArtistRepository):ViewModel(){
    val artistLiveData = MutableLiveData<ArtistModel>()
    val errorLiveData = MutableLiveData<String>()



    init {
//        fetchArtist()
    }

    fun fetchArtist(){
        viewModelScope.launch(Dispatchers.IO) {
            val resultObjects = artistRepository.getAllArtist()
            var artistNames = mutableListOf<String>()

            artistLiveData.postValue(resultObjects)

//            if(resultObjects!=null){
//                //200
//                for(x in resultObjects){
//                    artistNames.add(x?.artistName.toString())
//                }
//
//                artistLiveData.postValue(artistNames)
//            }else{
//                //404
//                Log.i("Data_Artist", "No Artist")
//
//
//            }

        }
    }
}