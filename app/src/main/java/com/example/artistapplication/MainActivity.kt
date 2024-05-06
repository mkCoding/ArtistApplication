package com.example.artistapplication

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.artistapplication.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: ArtistViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel.fetchArtist()

        viewModel.artistLiveData.observe(this){
            Log.i("Data_Artist", it[0].toString())
            Log.i("Data_Artist_List", "$it")


//            Toast.makeText(this,it.artistName?.get(0).toString(), Toast.LENGTH_LONG).show()
        }
        viewModel.artistLiveData.observe(this){
            Log.i("Data_Artist", "Error")
        }


        /*
        recyclerView
        *layout manager
        *adapter
     */




    }
}