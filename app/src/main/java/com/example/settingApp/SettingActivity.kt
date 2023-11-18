package com.example.settingApp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.secondapp.databinding.ActivitySettingBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.launch

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "setting")


/**
 * Tiene que ver con persistencia de datos y solicitud de permisos
 */
class SettingActivity : AppCompatActivity() {

    companion object {
        const val VOLUMEN_LVL = "volumen_lvl"
        const val MODO_OSCURO_CHECK = "modo_oscuro_check"
    }

    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUI()
        CoroutineScope(Dispatchers.IO).launch {
            getSettings().take(1).collect { d ->
                runOnUiThread{
                    binding.rsVolumen.value = d.volumen.toFloat()
                    binding.smModoOscuro.isChecked = d.modoOscuro
                }
            }
        }
    }

    private fun initUI() {
        binding.rsVolumen.addOnChangeListener { _, value, _ ->
            CoroutineScope(Dispatchers.IO).launch { saveVolumen(value.toInt()) }
        }

        binding.smModoOscuro.setOnCheckedChangeListener { _, b ->
            CoroutineScope(Dispatchers.IO).launch { saveOption(MODO_OSCURO_CHECK, b) }
        }
    }

    private suspend fun saveVolumen(valor: Int) {
        dataStore.edit { preference -> preference[intPreferencesKey(VOLUMEN_LVL)] = valor }
    }

    private suspend fun saveOption(key: String, value: Boolean) {
        dataStore.edit { preference -> preference[booleanPreferencesKey(key)] = value }
    }

    private fun getSettings(): Flow<SettingData> {
        return dataStore.data.map { preferences ->
            SettingData(
                volumen = preferences[intPreferencesKey(VOLUMEN_LVL)] ?: 25,
                modoOscuro = preferences[booleanPreferencesKey(MODO_OSCURO_CHECK)] ?: false
            )
        }
    }
}