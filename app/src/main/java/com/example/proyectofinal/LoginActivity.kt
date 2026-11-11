package com.example.proyectofinal

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    // credenciales correctas para acceder
    private val MYUSER = "juan"
    private val MYPASS = "1234"

    private lateinit var etUsuario: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnValidar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // conectamos los elementos del XML con el codigo
        etUsuario = findViewById(R.id.et_usuario)
        etPassword = findViewById(R.id.et_password)
        btnValidar = findViewById(R.id.btn_validar)

        // boton Validar: comprobamos usuario y contraseña
        btnValidar.setOnClickListener {
            val usuario = etUsuario.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (usuario == MYUSER && password == MYPASS) {
                // credenciales correctas, vamos al activity principal
                val intent = Intent(this, PrincipalActivity::class.java)
                startActivity(intent)
            } else {
                // credenciales incorrectas, mostramos un Toast
                Toast.makeText(this, R.string.msg_error_validacion, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
