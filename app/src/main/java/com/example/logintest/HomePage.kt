package com.example.logintest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomePage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val username = intent.getStringExtra("USERNAME")
        val buttonLogout = findViewById<Button>(R.id.buttonLogout)
        val textViewGreetings = findViewById<TextView>(R.id.textViewGreetings)

        textViewGreetings.text = "Bem vindo $username"

        buttonLogout.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}