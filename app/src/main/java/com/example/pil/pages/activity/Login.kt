package com.example.pil.pages.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG
import androidx.biometric.BiometricManager.Authenticators.DEVICE_CREDENTIAL
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.core.content.ContextCompat
import com.example.pil.R
import com.example.pil.databinding.ActivityLoginBinding
import java.util.concurrent.Executor


class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var executor: Executor
    private lateinit var biometricPrompt: BiometricPrompt
    private lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        prefs = getPreferences(Context.MODE_PRIVATE)
        val biometricLoginPrefs = prefs.getBoolean("biometricLogin", false)

        executor = ContextCompat.getMainExecutor(this)

        val callback = object : BiometricPrompt.AuthenticationCallback() {

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                intent = Intent(this@Login, Main::class.java)
                intent.putExtra("USERNAME", "Wellington")
                startActivity(intent)
                finish()
            }
        }

        biometricPrompt = BiometricPrompt(this, executor, callback)

        if (checkDeviceHasBiometric() && biometricLoginPrefs) {
            biometricPrompt.authenticate(createPromptInfo())
        }

        val inputEmail = findViewById<EditText>(R.id.editTextEmailAddress)
        val inputPassword = findViewById<EditText>(R.id.editTextPassword)
        val submitLoginButton = findViewById<Button>(R.id.buttonLogin)

        submitLoginButton.setOnClickListener {
            val inputEmailValue = inputEmail.text.toString()
            val inputPasswordValue = inputPassword.text.toString()

            if (inputEmailValue == "gbwellington@hotmail.com" && inputPasswordValue == "1234") {
                if (checkDeviceHasBiometric()) {
                    alertDialogBiometricLogin()
                } else {
                    intent = Intent(this@Login, Main::class.java)
                    intent.putExtra("USERNAME", "Wellington")
                    startActivity(intent)
                }
            } else if (inputEmailValue == "") {
                showError(inputEmail, "É necessário preencher o email")

            } else if (inputPasswordValue == "") {
                showError(inputPassword, "É necessário preencher a senha")
            } else {
                Toast.makeText(this, "Login ou senha inválidos", Toast.LENGTH_SHORT).show()
            }

        }
    }

    private fun alertDialogBiometricLogin() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("Deseja ativar a biometria")
        builder.setPositiveButton("Sim") { _, _ ->
            biometricPrompt.authenticate(createPromptInfo())
            prefs.edit().putBoolean("biometricLogin", true).apply()
        }
        builder.setNegativeButton("Não") { _, _ ->
            intent = Intent(this@Login, Main::class.java)
            intent.putExtra("USERNAME", "Wellington")
            startActivity(intent)
        }
        builder.create().show()
    }

    private fun createPromptInfo(): PromptInfo {
        return PromptInfo.Builder()
            .setTitle("PIL")
            .setSubtitle("")
            .setNegativeButtonText("cancelar")
            .build()
    }

    private fun checkDeviceHasBiometric(): Boolean {

        val biometricMaganer = BiometricManager.from(this)
        when (biometricMaganer.canAuthenticate(BIOMETRIC_STRONG or DEVICE_CREDENTIAL)) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                Log.d("BIOMETRIC_ON", "Can authenticate using biometrics")
                return true
            }
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                Log.d("BIOMETRIC_OFF", "Biometric device not find")
            }
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                val enrollment = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
                    putExtra(
                        Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                        BIOMETRIC_STRONG or DEVICE_CREDENTIAL
                    )
                }
                startActivityForResult(enrollment, 100)
            }
        }
        return false
    }

    private fun showError(inputName: TextView, message: String) {
        inputName.error = message
        inputName.requestFocus()
    }

}
