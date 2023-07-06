package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.hello.databinding.ActivityMainBinding
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    lateinit var  binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }

    override fun onResume() {
        super.onResume()
        binding.tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        binding.btnsignup.setOnClickListener {
            validateSignUp()
        }
    }


    fun validateSignUp() {
        val Firstname = binding.etFirstName.text.toString()
        val lastname = binding.etLastName.text.toString()
        val email = binding.etEmail.text.toString()
        val password = binding.etpassword.text.toString()
        val passwordConf = binding.etPasswordConfirmation.text.toString()
        var error = true

        if (Firstname.isBlank()) {
            binding.tilFirstName.error = "First name required"
            error = true
        }
        if (lastname.isBlank()) {
            binding.tilLastName.error = "Last name required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email required"
            error = true
        }
        if (password.isBlank()) {
            binding.tilPassword.error = "password required"
            error = true
        }
        if (passwordConf.isBlank()) {
            binding.tilPasswordconfirmation.error = "password confirmation required"
            error = true
        }
        if (password != passwordConf) {
            binding.tilPasswordconfirmation.error = "Password confirmation does not match password"
            error = true
        }

        if (!error) {
            Toast
                .makeText(this,"$Firstname $lastname $email",Toast.LENGTH_LONG)
                .show()



        }
    }
}