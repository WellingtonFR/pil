package com.example.logintest

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class Login : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val inputEmail = view.findViewById<EditText>(R.id.editTextEmailAddress)
        val inputPassword = view.findViewById<EditText>(R.id.editTextPassword)
        val submitLoginButton = view.findViewById<Button>(R.id.buttonLogin)

        fun showError(inputName: TextView, message: String) {
            inputName.error = message
            inputName.requestFocus()
        }

        submitLoginButton.setOnClickListener {
            val inputEmailValue = inputEmail.text.toString()
            val inputPasswordValue = inputPassword.text.toString()

            if (inputEmailValue == "gbwellington@hotmail.com" && inputPasswordValue == "1234") {
                val intent = Intent(context, Home::class.java)
                intent.putExtra("USERNAME", "Wellington")
                startActivity(intent)
            } else if (inputEmailValue == "") {
                showError(inputEmail, "É necessário preencher o email")

            } else if (inputPasswordValue == "") {
                showError(inputPassword, "É necessário preencher a senha")
            } else {
            Toast.makeText(context,"Login ou senha inválidos",Toast.LENGTH_SHORT).show()
            }
        }
    }
}