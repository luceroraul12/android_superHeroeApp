package com.example.superheroapp

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.databinding.ItemSearchSuperHeroBinding
import com.squareup.picasso.Picasso

class SuperHeroViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemSearchSuperHeroBinding.bind(view)

    fun bind(item: SuperHeroResult, onItemSelected: (String) -> Unit): Unit {
        binding.tvHeroName.text = item.name
        Picasso.get().load(item.image.url).into(binding.tvHeroImage)
        binding.root.setOnClickListener{onItemSelected(item.id)}
    }
}