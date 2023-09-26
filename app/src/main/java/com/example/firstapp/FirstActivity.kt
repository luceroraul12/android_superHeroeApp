package com.example.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.secondapp.R

class FirstActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnStart = findViewById<Button>(R.id.bBoton)
        val txTexto = findViewById<TextView>(R.id.tvTexto)
        var etNombre = findViewById<EditText>(R.id.etNombre)

        btnStart.setOnClickListener{
            var nombre: String = etNombre.text.toString();
            if (nombre.isNotEmpty()){
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("nombre", nombre)
                startActivity(intent)
            }
        }
    }
}