package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.firstapp.FirstActivity
import com.example.imcapp.ImcActivity
import com.example.secondapp.R

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val bPrimerApp = findViewById<Button>(R.id.bPrimerApp)
        val bSegundaApp = findViewById<Button>(R.id.bSegundaApp)

        bPrimerApp.setOnClickListener{goToView(FirstActivity::class.java)}

        bSegundaApp.setOnClickListener{goToView(ImcActivity::class.java)}
    }

    fun goToView(view: Class<*>){
        val intent = Intent(this, view)
        startActivity(intent)
    }
}