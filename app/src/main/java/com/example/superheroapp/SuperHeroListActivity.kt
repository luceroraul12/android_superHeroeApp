 package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.secondapp.databinding.ActivitySuperHeroListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

 class SuperHeroListActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySuperHeroListBinding
    private lateinit var retrofit: Retrofit

    private lateinit var adapter: SuperHeroAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        retrofit = getretrofit()
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

         adapter = SuperHeroAdapter()
         binding.rvHeroes.setHasFixedSize(true)
         binding.rvHeroes.layoutManager = LinearLayoutManager(this)
         binding.rvHeroes.adapter = adapter
     }

     private fun searchByName(query: String) {
        binding.pbSearch.isVisible = true
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<SuperHeroDataSearch> = retrofit.create(ApiService::class.java).getSuperHeroes(query)
            if (response.isSuccessful){
                Log.i("Funca", "funca ${response}")
                val data: SuperHeroDataSearch = response.body() ?: SuperHeroDataSearch()
                runOnUiThread {
                    adapter.updateList(data.superHeroResults)
                    binding.pbSearch.isVisible = false
                }
            }
        }

     }

     private fun getretrofit(): Retrofit {
         return Retrofit.Builder()
             .baseUrl("https://superheroapi.com/api/7099423040070314/")
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }
 }