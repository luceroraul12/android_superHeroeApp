package com.example.iterativeapp

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class TaskViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private var tvTaskItem: TextView = view.findViewById(R.id.tvTaskItem)
    fun render(task: String) {
        tvTaskItem.text = task
    }
}