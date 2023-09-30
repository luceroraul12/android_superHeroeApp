package com.example.iterativeapp

class TaskItem {
    public lateinit var label: String
    public lateinit var category: TaskCategory
    public var isCheck: Boolean = false

    constructor(label:String, category: TaskCategory, isCheck: Boolean) {
        this.label = label
        this.category = category
        this.isCheck = isCheck
    }


}