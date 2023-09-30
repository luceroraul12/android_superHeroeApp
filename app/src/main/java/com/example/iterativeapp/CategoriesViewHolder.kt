package com.example.iterativeapp

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class CategoriesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.tvCategoryName)
    private val vDivider: View = view.findViewById(R.id.vDivider)
    private val cvCategory: CardView = view.findViewById(R.id.cvCategory)
    fun render(taskCategory: TaskCategory, onItemSelected: (Int) -> Unit) {
        when(taskCategory){
            TaskCategory.Personal -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.firstColor))
                tvCategoryName.text = "Personal"
            }
            TaskCategory.Business -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.thirthColor))
                tvCategoryName.text = "Business"
            }
            TaskCategory.Other    -> {
                vDivider.setBackgroundColor(ContextCompat.getColor(vDivider.context,R.color.fourthColor))
                tvCategoryName.text = "Other"
            }
            else -> {}
        }

        itemView.setOnClickListener{
            onItemSelected(layoutPosition)

        }

        var color = if (taskCategory.isSelected) R.color.category_selected else R.color.category_unselected
        cvCategory.setCardBackgroundColor(ContextCompat.getColor(cvCategory.context, color));

    }

}