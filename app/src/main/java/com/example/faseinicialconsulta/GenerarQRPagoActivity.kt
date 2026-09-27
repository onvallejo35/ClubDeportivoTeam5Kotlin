package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class GenerarQRPagoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_generar_qr_pago)

        val dni = intent.getStringExtra("EXTRA_DNI") ?: ""

        findViewById<Button>(R.id.btnEscanearQRPago).setOnClickListener {
            val intent = Intent(this, QRPagoPantallaActivity::class.java).apply {
                putExtra("EXTRA_DNI", dni)
            }
            startActivity(intent)
            finish()
        }
    }
}