package com.example.lesson5

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tvLogin = findViewById<EditText>(R.id.tvLogin)
        val tvPassword = findViewById<EditText>(R.id.tvPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val btnRegistration = findViewById<Button>(R.id.btnRegistration)

        val preference = getSharedPreferences("Lesson5", Context.MODE_PRIVATE)

        btnLogin.setOnClickListener {
            val login = tvLogin.text.toString()
            val password = tvPassword.text.toString()

            val loginFromPref = preference.getString("login", "no saved data")
            val passwordFromPref = preference.getString("password", "no saved data")

            if (loginFromPref == login && passwordFromPref == password){
                val intent = Intent(applicationContext, ProfileActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this,"Логин или пароль не верны", Toast.LENGTH_LONG).show()
            }
        }

        btnRegistration.setOnClickListener {

            preference.edit().putString("login", tvLogin.text.toString()).apply()
            preference.edit().putString("password", tvPassword.text.toString()).apply()

            Toast.makeText(this,"Логин и пароль успешно сохранены", Toast.LENGTH_LONG).show()

            tvLogin.setText("")
            tvPassword.setText("")
        }


    }
}