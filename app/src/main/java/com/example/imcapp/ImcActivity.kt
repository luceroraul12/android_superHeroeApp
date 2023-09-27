package com.example.imcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.secondapp.R
import com.google.android.material.slider.Slider
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var esHombre: Boolean = true;
    private var altura: Double = 100.0;
    private var peso: Double = 25.0;
    private var edad: Double = 25.0;

    private lateinit var cardHombre: CardView;
    private lateinit var cardMujer: CardView;
    private lateinit var slideAltura: Slider;
    private lateinit var textViewAltura: TextView;
    private lateinit var textViewPeso: TextView;
    private lateinit var textViewEdad: TextView;
    private lateinit var buttonAumentarEdad: AppCompatImageButton;
    private lateinit var buttonDisminuirEdad: AppCompatImageButton;
    private lateinit var buttonAumentarPeso: AppCompatImageButton;
    private lateinit var buttonDisminuirPeso: AppCompatImageButton;
    private lateinit var buttonCalcularIMC: AppCompatButton;

    companion object {
        const val IMC_RESULTADO_KEY = "IMC_RESULTADO_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        iniciarComponentes();
        iniciarEscuchadores();
    }


    private fun iniciarComponentes() {
        cardHombre = findViewById(R.id.cvMale)
        cardMujer = findViewById(R.id.cvFemale)
        slideAltura = findViewById(R.id.sAltura)

        textViewAltura = findViewById(R.id.tvAltura)
        textViewPeso = findViewById(R.id.tvPeso)
        textViewEdad = findViewById(R.id.tvEdad)

        buttonAumentarPeso = findViewById(R.id.bAumentarPeso)
        buttonDisminuirPeso = findViewById(R.id.bDisminuirPeso)
        buttonAumentarEdad = findViewById(R.id.bAumentarEdad)
        buttonDisminuirEdad = findViewById(R.id.bDisminuirEdad)
        buttonCalcularIMC = findViewById(R.id.bCalcular)

        setInitValores();

    }

    private fun setInitValores() {
        setEsHombre(this.esHombre);

        val df = DecimalFormat("#.##")
        val alturaFinal = df.format(altura)
        this.altura = altura.toDouble()
        this.textViewAltura.text = "$alturaFinal cm";
        setEdad();
        setPeso();
    }

    private fun iniciarEscuchadores() {
        cardHombre.setOnClickListener{setEsHombre(true)}
        cardMujer.setOnClickListener{setEsHombre(false)}
        slideAltura.addOnChangeListener { slider, altura, fromUser ->
            val df = DecimalFormat("#.##")
            val alturaFinal = df.format(altura)
            this.altura = altura.toDouble()
            this.textViewAltura.text = "$alturaFinal cm";
        }
        buttonAumentarPeso.setOnClickListener{aumentarPeso()}
        buttonDisminuirPeso.setOnClickListener {disminuirPeso()}
        buttonAumentarEdad.setOnClickListener {aumentarEdad()}
        buttonDisminuirEdad.setOnClickListener {disminuirEdad()}
        buttonCalcularIMC.setOnClickListener{calcularIMC()}

    }

    private fun setEsHombre(esHombre: Boolean) {
        this.esHombre = esHombre;
        cardHombre.setCardBackgroundColor(getBackgroundColor(this.esHombre))
        cardMujer.setCardBackgroundColor(getBackgroundColor(!this.esHombre))
    }

    private fun getBackgroundColor(check: Boolean): Int {
        val colorSeleccionado: Int = if (check) R.color.purple_light else R.color.black;
        return ContextCompat.getColor(this, colorSeleccionado)
    }

    private fun aumentarEdad(){
        this.edad += 1;
        setEdad()
    }

    private fun disminuirEdad(){
        this.edad -= 1;
        setEdad()

    }

    private fun aumentarPeso(){
        this.peso += 1;
        setPeso()
    }

    private fun disminuirPeso(){
        this.peso -= 1;
        setPeso()
    }

    private fun setPeso() {
        textViewPeso.text = this.peso.toString()
    }

    private fun setEdad() {
        textViewEdad.text = this.edad.toString()
    }

    private fun calcularIMC() {
        val alturaMetro: Double = altura / 100.0
        val imc = peso / (alturaMetro * alturaMetro)
        Log.i("peso", peso.toString())
        Log.i("altura", altura.toString())
        Log.i("prueba", altura.toString())

        Log.i("prueba", imc.toString())

        val intent = Intent(this, ResultImcActivity::class.java)
        intent.putExtra(IMC_RESULTADO_KEY, imc)
        startActivity(intent)
    }
}