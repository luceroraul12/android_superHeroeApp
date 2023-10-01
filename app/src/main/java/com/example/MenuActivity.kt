package com.exampleApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.firstapp.FirstActivity
import com.example.imcapp.ImcActivity
import com.example.iterativeapp.IterativeActivity
import com.example.secondapp.R
import com.example.settingApp.SettingActivity
import com.example.superheroapp.SuperHeroListActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bPrimerApp = findViewById<Button>(R.id.bPrimerApp)
        val bSegundaApp = findViewById<Button>(R.id.bSegundaApp)
        val bTerceraApp = findViewById<Button>(R.id.bTerceraApp)
        val bSuperHeroApp = findViewById<Button>(R.id.bSuperHeroApp)
        val bSettingApp = findViewById<Button>(R.id.bSettingApp)

        bPrimerApp.setOnClickListener{goToView(FirstActivity::class.java)}
        bSegundaApp.setOnClickListener{goToView(ImcActivity::class.java)}
        bTerceraApp.setOnClickListener{goToView(IterativeActivity::class.java)}
        bSuperHeroApp.setOnClickListener { goToView(SuperHeroListActivity::class.java) }
        bSettingApp.setOnClickListener { goToView(SettingActivity::class.java) }
    }

    fun goToView(view: Class<*>){
        val intent = Intent(this, view)
        startActivity(intent)
    }
}