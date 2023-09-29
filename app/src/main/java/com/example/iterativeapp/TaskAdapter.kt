package com.example.iterativeapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R

class TaskAdapter(private var task: List<String>): RecyclerView.Adapter<TaskViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount() = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.render(task.get(position))
    }
}