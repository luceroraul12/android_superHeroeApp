package com.example.iterativeapp

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.vDivider)
    fun render(taskCategory: TaskCategory) {
        when(taskCategory){
            TaskCategory.Personal -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.firstColor))
                tvCategoryName.text = "Personal"
            }
            TaskCategory.Business -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.thirthColor))
                tvCategoryName.text = "Trabajo"
            }
            TaskCategory.Other    -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.fourthColor))
                tvCategoryName.text = "Otros"
            }
        }
    }

}