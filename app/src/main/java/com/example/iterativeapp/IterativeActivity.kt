package com.example.iterativeapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.secondapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class IterativeActivity : AppCompatActivity() {

    private val categories = listOf<TaskCategory>(
        TaskCategory.Personal,
        TaskCategory.Business,
        TaskCategory.Other
    )

    private val tasks = mutableListOf(
        TaskItem("Personal task",TaskCategory.Personal, true),
        TaskItem("Business task",TaskCategory.Business, false),
        TaskItem("Other task",TaskCategory.Other, false)
    )

    private lateinit var rvCategories : RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter

    private lateinit var rvTasks: RecyclerView
    private lateinit var taskAdapter: TaskAdapter
    private lateinit var fabAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_iterative)

        initComponent()
        initListener()
        initUI()
    }


    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories) {onCategorySelected(it)}
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        taskAdapter = TaskAdapter(tasks) { onTaskSelected(it) }
        rvTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvTasks.adapter = taskAdapter

    }

    private fun onCategorySelected(position: Int): Unit {
        var categorySelected = categories[position]
        categorySelected.isSelected = categorySelected.isSelected.not()

        updateCategory(position)
        updateTasks()
    }

    private fun onTaskSelected(position: Int): Unit {
        // Luego de invertir el check, debo volver a actualizar con el adapter de task para que me refleje el cambio
        tasks[position].isCheck = tasks[position].isCheck.not()
        updateTasks()
    }

    private fun initComponent() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.fabAddTask)

    }
    private fun initListener() {
        fabAddTask.setOnClickListener {
            showMyDialog()
        }
    }

    private fun showMyDialog() {
        var dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_new_task)

        val bAddTask: AppCompatButton = dialog.findViewById(R.id.bAddTask)
        val etAddDrescription: EditText = dialog.findViewById(R.id.etAddDescription)
        val rgCategory: RadioGroup = dialog.findViewById(R.id.rgCategory)

        bAddTask.setOnClickListener{
            val description = etAddDrescription.text.toString()
            // Valido que la descripcion no se encuentre vacia al momento de pulsar el boton
            if(description.isNotEmpty()){
            val selectedId = rgCategory.checkedRadioButtonId
            val selectedRadioButton: RadioButton = rgCategory.findViewById(selectedId)
            val currentCategory: TaskCategory = when(selectedRadioButton.text){
                getString(R.string.business) -> TaskCategory.Business
                getString(R.string.personal) -> TaskCategory.Personal
                else -> TaskCategory.Other
            }

            tasks.add(TaskItem(description, currentCategory, false))
            // Debo avisarle al adapter de que debe actualizar la vista
            updateTasks()
            dialog.hide()
            }
        }
        dialog.show()
    }

    private fun updateTasks(){
        val selectedCategories: List<TaskCategory> = categories.filter(TaskCategory::isSelected)
        val taskFromSelectedCategories = tasks.filter { selectedCategories.contains(it.category) }

        taskAdapter.task = taskFromSelectedCategories

        taskAdapter.notifyDataSetChanged()
    }

    private fun updateCategory(position: Int) {
        categoriesAdapter.notifyItemChanged(position)
    }

}