package com.example.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        showActivity()

        val button4 = findViewById<Button>(R.id.button4)

        button4.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }

    fun showActivity(){
        Toast.makeText(this, "Está en la activity 4", Toast.LENGTH_SHORT).show()
    }
}