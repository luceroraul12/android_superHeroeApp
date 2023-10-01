package com.example.superheroapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class SuperHeroAdapter(var superHeroList: List<SuperHeroResult> = emptyList()) :
    RecyclerView.Adapter<SuperHeroViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_search_super_hero, parent, false)
        return SuperHeroViewHolder(view)
    }

    override fun getItemCount(): Int = superHeroList.size

    override fun onBindViewHolder(holder: SuperHeroViewHolder, position: Int) {
        holder.bind(superHeroList.get(position))
    }

    fun updateList(list: List<SuperHeroResult>){
        this.superHeroList = list
        notifyDataSetChanged()
    }
}