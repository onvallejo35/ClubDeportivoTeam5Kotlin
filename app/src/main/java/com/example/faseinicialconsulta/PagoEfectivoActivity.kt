package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PagoEfectivoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_efectivo)

        val etMonto = findViewById<EditText>(R.id.etMontoEfectivo)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmarEfectivo)
        val dni = intent.getStringExtra("EXTRA_DNI") ?: ""

        btnConfirmar.setOnClickListener {
            val monto = etMonto.text.toString().toDoubleOrNull() ?: 0.0
            if (monto <= 0) {
                Toast.makeText(this, "Ingrese un monto válido recibido", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            SocioRepository.buscarPorDni(dni)?.let { it.cuotaAlDia = true }

            val intent = Intent(this, PagoExitoActivity::class.java).apply {
                putExtra("EXTRA_DETALLE", "Pago en Efectivo Registrado: $$monto")
            }
            startActivity(intent)
            finish()
        }
    }
}