package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PagoDebitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_debito)

        val etTarjeta = findViewById<EditText>(R.id.etNumTarjetaDebito)
        val btnPagar = findViewById<Button>(R.id.btnConfirmarDebito)
        val dni = intent.getStringExtra("EXTRA_DNI") ?: ""

        btnPagar.setOnClickListener {
            if (etTarjeta.text.toString().length < 16) {
                Toast.makeText(this, "Número de tarjeta inválido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            SocioRepository.buscarPorDni(dni)?.let { it.cuotaAlDia = true }

            val intent = Intent(this, PagoExitoActivity::class.java).apply {
                putExtra("EXTRA_DETALLE", "Pago con Débito Procesado")
            }
            startActivity(intent)
            finish()
        }
    }
}