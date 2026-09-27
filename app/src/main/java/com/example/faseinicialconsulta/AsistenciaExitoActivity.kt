package com.example.faseinicialconsulta // CORREGIDO: Debe coincidir con la carpeta

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.clubdeportivoteam5kotlin.MainActivity
import com.example.faseinicialconsulta.R.*
import com.example.faseinicialconsulta.btnVolverMenuAsistencia

private val Unit.btnVolverMenuAsistencia: Int
private val Unit.btnVolverMenuAsistencia: Int
private val Unit.btnVolverMenuAsistencia: Int

class AsistenciaExitoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_asistencia_exito)

        // Buscamos el botón por su ID
        val btnVolver = findViewById<Button>(/* id = */ id.btnVolverMenuAsistencia)

        btnVolver.setOnClickListener {
            // Asegúrate de que MainActivity también esté en el paquete com.example.faseinicialconsulta
            val intent = Intent(this, MainActivity::class.java)

            // Esta bandera limpia la pila de actividades para volver al inicio correctamente
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()
        }
    }
}