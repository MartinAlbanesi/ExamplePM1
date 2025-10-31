package com.example.examplepm1.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.examplepm1.R
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {

    // Mocked user data for testing purposes
    private lateinit var mockUsername: String
    private lateinit var mockPassword: String

    private lateinit var usernameEditText: TextInputEditText
    private lateinit var passwordEditText: TextInputEditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Inicializo los datos del usuario mockeados
        mockUsername = "admin"
        mockPassword = "password123."

        usernameEditText = findViewById(R.id.username_edit_text)
        passwordEditText = findViewById(R.id.password_edit_text)
        loginButton = findViewById(R.id.login_button)

        onClickLogin()
    }

    fun onClickLogin() {
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Valida el usuario y la contraseña
            if (!checkUsername(username)) {
                return@setOnClickListener
            }

            if (!checkPassword(password)) {
                return@setOnClickListener
            }

            // Verifica el usuario y la contraseña
            if (verifyUser(username, password)) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
    }

    // Función que valida el nombre de usuario: debe tener menos de 20 caracteres
    fun checkUsername(username: String): Boolean {
        if (username.length >= 20) {
            usernameEditText.error = "El nombre de usuario no puede tener más de 20 caracteres"
            return false
        }
        return true
    }

    // Función que valida la contraseña: debe contener al menos un número y un símbolo
    fun checkPassword(password: String): Boolean {
        if (!password.any { it.isDigit() } || password.all { it.isLetterOrDigit() }) {
            passwordEditText.error =
                "La contraseña debe contener al menos un número y un símbolo"
            return false
        }
        return true
    }


    fun verifyUser(username: String, password: String): Boolean {
        // Compara el usuario y la contraseña con los datos mockeados
        if (username == mockUsername && password == mockPassword) {
            Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
            return true
        } else {
            Toast.makeText(this, "Credenciales incorrectas", Toast.LENGTH_SHORT).show()
            return false
        }
    }
}
