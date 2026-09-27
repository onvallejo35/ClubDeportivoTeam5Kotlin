package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnRegistrarPersona).setOnClickListener {
            startActivity(Intent(this, RegistroPersonaActivity::class.java))
        }
        findViewById<Button>(R.id.btnCargarPago).setOnClickListener {
            startActivity(Intent(this, BuscarPagoActivity::class.java))
        }
        findViewById<Button>(R.id.btnCrearCarnet).setOnClickListener {
            startActivity(Intent(this, BuscarSocioCarnetActivity::class.java))
        }
        findViewById<Button>(R.id.btnListadoVencidos).setOnClickListener {
            startActivity(Intent(this, ListadoVencidosActivity::class.java))
        }
        findViewById<Button>(R.id.btnRegistrarAsistencia).setOnClickListener {
            startActivity(Intent(this, AsistenciasMenuActivity::class.java))
        }
    }
}