package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AsistenciaResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asistencias_resultado)

        val tvResultado = findViewById<TextView>(R.id.tvResultadoEscaneo)
        val btnConfirmar = findViewById<Button>(R.id.btnConfirmarAsistencia)

        val dni = intent.getStringExtra("EXTRA_DNI_SIMULADO") ?: "12345678"
        val socio = SocioRepository.buscarPorDni(dni)

        if (socio != null && socio.cuotaAlDia && socio.aptoFisicoCargado) {
            tvResultado.text = "ACCESO PERMITIDO\n${socio.nombre} ${socio.apellido}\nCuota y Apto Vigentes"
        } else {
            tvResultado.text = "ACCESO DENEGADO\nCuota o Apto Vencido"
        }

        btnConfirmar.setOnClickListener {
            startActivity(Intent(this, AsistenciaExitoActivity::class.java))
            finish()
        }
    }
}