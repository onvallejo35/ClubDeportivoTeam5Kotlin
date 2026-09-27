package com.example.faseinicialconsulta

import com.example.faseinicialconsulta.R
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.clubdeportivoteam5kotlin.AsistenciaResultadoActivity

class AsistenciaEscanerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asistencias_escaner)

        val tipo = intent.getStringExtra("EXTRA_TIPO_ASISTENCIA") ?: "Socio"

        findViewById<Button>(R.id.btnSimularEscaneo).setOnClickListener {
            val intent = Intent(this, AsistenciaResultadoActivity::class.java).apply {
                putExtra("EXTRA_TIPO_ASISTENCIA", tipo)
                putExtra("EXTRA_DNI_SIMULADO", "12345678")
            }
            startActivity(intent)
            finish()
        }
    }
}