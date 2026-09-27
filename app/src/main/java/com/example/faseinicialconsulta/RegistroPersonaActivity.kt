package com.example.clubdeportivoteam5kotlin

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegistroPersonaActivity : AppCompatActivity() {
    private var aptoCargado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro_persona)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etApellido = findViewById<EditText>(R.id.etApellido)
        val etDni = findViewById<EditText>(R.id.etDni)
        val etCorreo = findViewById<EditText>(R.id.etCorreo)
        val cbApto = findViewById<CheckBox>(R.id.cbAptoFisico)
        val btnFotoApto = findViewById<Button>(R.id.btnCargarFotoApto)
        val btnContinuar = findViewById<Button>(R.id.btnContinuarRegistro)

        btnFotoApto.setOnClickListener {
            aptoCargado = true
            cbApto.isChecked = true
            Toast.makeText(this, "Foto de Apto Físico capturada correctamente", Toast.LENGTH_SHORT).show()
        }

        btnContinuar.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val apellido = etApellido.text.toString().trim()
            val dni = etDni.text.toString().trim()
            val correo = etCorreo.text.toString().trim()

            if (nombre.isEmpty() || apellido.isEmpty() || dni.isEmpty() || correo.isEmpty()) {
                Toast.makeText(this, "Todos los campos personales son obligatorios", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!aptoCargado) {
                Toast.makeText(this, "La persona debe presentar apto físico", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (SocioRepository.buscarPorDni(dni) != null) {
                Toast.makeText(this, "Ya existe una persona registrada con ese DNI", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            val intent = Intent(this, RegistroMembresiaActivity::class.java).apply {
                putExtra("EXTRA_NOMBRE", nombre)
                putExtra("EXTRA_APELLIDO", apellido)
                putExtra("EXTRA_DNI", dni)
                putExtra("EXTRA_CORREO", correo)
            }
            startActivity(intent)
        }
    }
}