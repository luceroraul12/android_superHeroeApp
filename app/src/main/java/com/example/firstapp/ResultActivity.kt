package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.secondapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResultado = findViewById<TextView>(R.id.tvResultado)
        var nombre: String? = intent.extras?.getString("nombre")
        tvResultado.text = "Wenas $nombre"
    }
}