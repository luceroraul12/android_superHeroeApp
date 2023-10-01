package com.example.settingApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.secondapp.R
import com.example.secondapp.databinding.ActivitySettingBinding

/**
 * Tiene que ver con persistencia de datos y solicitud de permisos
 */
class SettingActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}