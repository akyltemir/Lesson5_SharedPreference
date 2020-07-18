package com.example.lesson5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class ProfileActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)


        val tvLogin = findViewById<EditText>(R.id.tvLogin)
        val tvPassword = findViewById<EditText>(R.id.tvPassword)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnSignOut = findViewById<Button>(R.id.btnSignOut)

        val preference = getSharedPreferences("Lesson5", Context.MODE_PRIVATE)

        btnUpdate.setOnClickListener {
            preference.edit().putString("login", tvLogin.text.toString()).apply()
            preference.edit().putString("password", tvPassword.text.toString()).apply()

            Toast.makeText(this,"Данные обновлены", Toast.LENGTH_LONG).show()
        }

        btnSignOut.setOnClickListener {
            preference.edit().putString("login", "").apply()
            preference.edit().putString("password", "").apply()

            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}