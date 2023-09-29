package com.example.iterativeapp

sealed class TaskCategory {
    object Personal : TaskCategory()
    object Business : TaskCategory()
    object Other    : TaskCategory()
}