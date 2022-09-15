package com.example.latihandatabinding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.latihandatabinding.databinding.ItemBeritaBinding


class AdapterBerita (var listBerita : ArrayList<DataClassBerita>, private val klik:MainActivity) : RecyclerView.Adapter<AdapterBerita.ViewHolder>(){


    class ViewHolder(val binding : ItemBeritaBinding):RecyclerView.ViewHolder(binding.root){
        fun databind(itemData : DataClassBerita, listener: MainActivity) {
            binding.berita = itemData
            binding.eventKlik = listener

        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.databind(listBerita[position], klik )

    }

    override fun getItemCount(): Int {
        return listBerita.size
    }
    interface ItemClickListener{
        fun onItemClicked(detail : DataClassBerita)
    }


}