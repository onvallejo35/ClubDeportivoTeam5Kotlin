package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PagoCreditoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_credito)

        val etTarjeta = findViewById<EditText>(R.id.etNumTarjetaCredito)
        val etCvc = findViewById<EditText>(R.id.etCvcCredito)
        val btnPagar = findViewById<Button>(R.id.btnConfirmarCredito)
        val dni = intent.getStringExtra("EXTRA_DNI") ?: ""

        btnPagar.setOnClickListener {
            if (etTarjeta.text.toString().length < 16 || etCvc.text.toString().length < 3) {
                Toast.makeText(this, "Complete correctamente los datos de la tarjeta", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            SocioRepository.buscarPorDni(dni)?.let { it.cuotaAlDia = true }

            val intent = Intent(this, PagoExitoActivity::class.java).apply {
                putExtra("EXTRA_DETALLE", "Pago con Tarjeta de Crédito Procesado")
            }
            startActivity(intent)
            finish()
        }
    }
}