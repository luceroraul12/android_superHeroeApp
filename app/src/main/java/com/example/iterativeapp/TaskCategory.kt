package com.example.iterativeapp

sealed class TaskCategory(var isSelected: Boolean = false) {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other    : TaskCategory()
}