package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegistroExitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_exito)

        val tvMensaje = findViewById<TextView>(R.id.tvMensajeExito)
        val btnVolver = findViewById<Button>(R.id.btnVolverMenu)

        tvMensaje.text = intent.getStringExtra("EXTRA_MENSAJE") ?: "Registro guardado correctamente"

        btnVolver.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            startActivity(intent)
            finish()
        }
    }
}