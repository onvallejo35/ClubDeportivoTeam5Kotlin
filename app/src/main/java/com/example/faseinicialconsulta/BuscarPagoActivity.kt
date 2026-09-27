package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BuscarPagoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscar_pago)

        val etDni = findViewById<EditText>(R.id.etDniPago)
        val rgMedio = findViewById<RadioGroup>(R.id.rgMedioPago)
        val btnBuscar = findViewById<Button>(R.id.btnContinuarPago)

        btnBuscar.setOnClickListener {
            val dni = etDni.text.toString().trim()
            if (dni.isEmpty()) {
                Toast.makeText(this, "Ingrese el DNI de la persona", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val socio = SocioRepository.buscarPorDni(dni)
            if (socio == null) {
                Toast.makeText(this, "No hay socio o no socio activo con ese DNI", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val destinationClass = when (rgMedio.checkedRadioButtonId) {
                R.id.rbCredito -> PagoCreditoActivity::class.java
                R.id.rbDebito -> PagoDebitoActivity::class.java
                R.id.rbEfectivo -> PagoEfectivoActivity::class.java
                R.id.rbQR -> GenerarQRPagoActivity::class.java
                else -> PagoCreditoActivity::class.java
            }

            val intent = Intent(this, destinationClass).apply {
                putExtra("EXTRA_DNI", socio.dni)
            }
            startActivity(intent)
        }
    }
}