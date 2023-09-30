 package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.SearchView
import com.example.secondapp.R
import com.example.secondapp.databinding.ActivitySuperHeroListBinding

 class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
    }

     private fun initUI() {
         binding.svMain.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
             override fun onQueryTextSubmit(query: String?): Boolean {
                searchByName(query.orEmpty())
                 return false
             }

             override fun onQueryTextChange(newText: String?): Boolean = false
         })
     }

     private fun searchByName(query: String) {

     }
 }