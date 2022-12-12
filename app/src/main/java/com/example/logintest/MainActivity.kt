package com.example.logintest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputEmail = findViewById<EditText>(R.id.editTextEmailAddress)
        val inputPassword = findViewById<EditText>(R.id.editTextPassword)
        val submitLoginButton = findViewById<Button>(R.id.buttonLogin)

        fun showError(inputName: TextView, message: String) {
            inputName.setError(message)
            inputName.requestFocus()
        }

        submitLoginButton.setOnClickListener {
            val inputEmailValue = inputEmail.text.toString()
            val inputPasswordValue = inputPassword.text.toString()

            if (inputEmailValue == "gbwellington@hotmail.com" && inputPasswordValue == "1234") {
                val intent = Intent(this, HomePage::class.java)
                intent.putExtra("USERNAME", "Wellington")
                startActivity(intent)
            } else if (inputEmailValue == "") {
                showError(inputEmail, "É necessário preencher o email")

            } else if (inputPasswordValue == "") {
                showError(inputPassword, "É necessário preencher a senha")
            } else {
            Toast.makeText(this,"Login ou senha inválidos",Toast.LENGTH_SHORT).show()
            }
        }
    }
}