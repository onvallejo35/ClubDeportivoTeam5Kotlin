package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ListadoVencidosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listado_vencidos)

        val tvLista = findViewById<TextView>(R.id.tvListaSociosVencidos)
        val btnNotificar = findViewById<Button>(R.id.btnEnviarRecordatorioMasivo)

        val vencidos = SocioRepository.listaSocios.filter { !it.cuotaAlDia }

        if (vencidos.isEmpty()) {
            tvLista.text = "No hay socios con cuota vencida o a vencer hoy"
            btnNotificar.isEnabled = false
        } else {
            val sb = StringBuilder()
            vencidos.forEach {
                sb.append("• ${it.nombre} ${it.apellido} - DNI: ${it.dni} (Vencimiento: ${it.fechaVencimiento})\n")
            }
            tvLista.text = sb.toString()
        }

        btnNotificar.setOnClickListener {
            startActivity(Intent(this, NotificacionEnviadaActivity::class.java))
            finish()
        }
    }
}