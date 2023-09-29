package com.example.iterativeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class CategoriesAdapter(private val categories: List<TaskCategory>):
    RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.render(categories.get(position))
    }

    override fun getItemCount(): Int = categories.size
}