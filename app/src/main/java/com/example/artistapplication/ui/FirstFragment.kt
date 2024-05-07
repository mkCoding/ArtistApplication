package com.example.artistapplication.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artistapplication.databinding.FragmentFirstBinding
import com.example.artistapplication.viewmodel.ArtistViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

@AndroidEntryPoint
class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //Handle the UI changes based on current state
        binding = FragmentFirstBinding.inflate(layoutInflater,container,false)
        val artistViewModel = ViewModelProvider(this)[ArtistViewModel::class.java]

        var root = binding.root

        artistViewModel.fetchArtist()

        //observe data from view model
        artistViewModel.artistLiveData.observe(viewLifecycleOwner){
            Log.i("Data_Artist", it.results?.get(0)?.artistName.toString())
            Log.i("Data_Artist_List", "$it") //list of all artist names

            binding.rvArtist.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = ArtistListAdapter (it)
            }
        }

        /*
        recyclerView
            *layout manager
            *adapter
    */


        return root
    }

}