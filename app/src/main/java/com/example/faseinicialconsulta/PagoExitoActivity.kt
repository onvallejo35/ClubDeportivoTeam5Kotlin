package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PagoExitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pago_exito)

        val tvDetalle = findViewById<TextView>(R.id.tvDetallePagoExito)
        tvDetalle.text = intent.getStringExtra("EXTRA_DETALLE") ?: "Pago registrado correctamente"

        findViewById<Button>(R.id.btnVolverMenuPago).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}