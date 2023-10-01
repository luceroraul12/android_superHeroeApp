package com.example.superheroapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import com.example.secondapp.databinding.ActivitySuperHeroeDetailBinding
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import kotlin.math.roundToInt

class SuperHeroeDetailActivity : AppCompatActivity() {

    private lateinit var retrofit: Retrofit
    private lateinit var binding: ActivitySuperHeroeDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySuperHeroeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val superHeroId: String = intent.getStringExtra(SuperHeroListActivity.EXTRA_SUPERHERO_ID).orEmpty()
        retrofit = getRetrofit()
        getSuperHeroDetail(superHeroId)
    }

    private fun getSuperHeroDetail(superHeroId: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val response: Response<SuperHeroDetail> =
                retrofit.create(ApiService::class.java).getSuperHeroeDetail(superHeroId)
            if (response.isSuccessful) {
                val data: SuperHeroDetail = response.body() ?: SuperHeroDetail()
                runOnUiThread {
                    createUI(data)
                }
            }
        }

    }

    private fun createUI(data: SuperHeroDetail) {
        // fijo el nombre del superheroe
        binding.tvHeroeDetailName.text = data.name
        // fijo la imagen del superheroe
        Picasso.get().load(data.image.url).into(binding.ivHeroe)
        // fijo los altos de cada atribuuto del superheroe
        setStats(data.powerStats)
    }

    private fun setStats(stats: PowerStats) {
        setStatSize(binding.vIntelligence, stats.intelligence)
        setStatSize(binding.vStrength, stats.strength)
        setStatSize(binding.vCombat, stats.combat)
        setStatSize(binding.vSpeed, stats.speed)
        setStatSize(binding.vDurability, stats.durability)
        setStatSize(binding.vPower, stats.power)
    }

    private fun setStatSize(view: View, stat: String) {
        val params = view.layoutParams
        params.height = convertPixelToDp(stat.toFloat())
        // debo volver a fijar el layoutparam para ver los cambios
        view.layoutParams = params
    }

    private fun convertPixelToDp(value: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, resources.displayMetrics).roundToInt()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://superheroapi.com/api/7099423040070314/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}