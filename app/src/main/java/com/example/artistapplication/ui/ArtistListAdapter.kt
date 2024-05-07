package com.example.artistapplication.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.artistapplication.R
import com.example.artistapplication.databinding.ElementArtistBinding
import com.example.artistapplication.model.ArtistModel
import com.example.artistapplication.model.ResultModel

class ArtistListAdapter(
    val artistList: ArtistModel
): RecyclerView.Adapter<ArtistListAdapter.MyViewHolder>(){


    inner class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ElementArtistBinding.bind(itemView)

        fun updateUI(elementResultModel: ResultModel?) {
            //Handle the UI changes based on current state
            binding.apply {
                //add the details to layout file
                Glide.with(itemView.context).load(elementResultModel?.artworkUrl60).placeholder(R.drawable.person_icon).into(ivArtistImage)
                tvArtistName.text = elementResultModel?.artistName
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistListAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.element_artist, parent, false))
    }

    override fun onBindViewHolder(holder: ArtistListAdapter.MyViewHolder, position: Int) {
        holder.updateUI(artistList.results?.get(position))


    }

    override fun getItemCount(): Int {
       return artistList.results?.size?.toInt() ?: 0
    }


}