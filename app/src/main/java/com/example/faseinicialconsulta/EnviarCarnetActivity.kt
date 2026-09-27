package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EnviarCarnetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enviar_carnet)

        val tvDatos = findViewById<TextView>(R.id.tvDatosSocioCarnet)
        val btnEnviar = findViewById<Button>(R.id.btnEnviarCarnet)

        val nombre = intent.getStringExtra("EXTRA_NOMBRE_COMPLETO") ?: ""
        val dni = intent.getStringExtra("EXTRA_DNI") ?: ""

        tvDatos.text = "Socio: $nombre\nDNI: $dni\nEstado: Al día"

        btnEnviar.setOnClickListener {
            startActivity(Intent(this, EnviarCarnetExitoActivity::class.java))
            finish()
        }
    }
}