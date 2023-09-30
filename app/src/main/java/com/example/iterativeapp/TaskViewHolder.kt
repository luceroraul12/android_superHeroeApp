package com.example.iterativeapp

import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var tvTaskItem: TextView = view.findViewById(R.id.tvTaskItem)
    private var cbTaskItem: CheckBox = view.findViewById(R.id.cbTaskItem)
    private var rowTaskItem: CardView = view.findViewById(R.id.rowTaskItem)
    fun render(task: TaskItem) {
        tvTaskItem.text = task.label
        cbTaskItem.isChecked = task.isCheck

        if(task.isCheck){
            tvTaskItem.paintFlags = tvTaskItem.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTaskItem.paintFlags = tvTaskItem.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        // para setear el color del check
        val color = when (task.category) {
            TaskCategory.Business -> R.color.thirthColor
            TaskCategory.Other -> R.color.fourthColor
            TaskCategory.Personal -> R.color.firstColor
        }
        cbTaskItem.buttonTintList = ColorStateList.valueOf(
            ContextCompat.getColor(cbTaskItem.context, color)
        )
    }
    
}