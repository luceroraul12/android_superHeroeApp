package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import com.example.imcapp.ImcActivity.Companion.IMC_RESULTADO_KEY
import com.example.secondapp.R

class ResultImcActivity : AppCompatActivity() {

    private lateinit var buttonVolver: AppCompatButton
    private lateinit var textViewResultadoCalculado: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imc)

        initComponentes();
        setValores()
        initListener();
    }

    private fun setValores() {
        val imc: Double = intent.extras?.getDouble(IMC_RESULTADO_KEY) ?: -1.0
        textViewResultadoCalculado.text = imc.toString()
    }

    private fun initListener() {
        buttonVolver.setOnClickListener{onBackPressed()}
    }

    private fun initComponentes() {
        buttonVolver = findViewById(R.id.bVolver)
        textViewResultadoCalculado = findViewById(R.id.tvResultadoCalculado)
    }
}