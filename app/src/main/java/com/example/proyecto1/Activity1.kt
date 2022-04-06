package com.example.proyecto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide

class Activity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_1)

        showActivity()
        getAndShowName()


        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intento1 = Intent(this, Activity2::class.java)
            startActivity(intento1)
        }

        val btnSens = findViewById<Button>(R.id.btnSens)
        btnSens.setOnClickListener {
            val intento1 = Intent(this, Activity3::class.java)
            startActivity(intento1)
        }

        val imageView1 = findViewById<ImageView>(R.id.iv1);
        Glide.with(this).load(R.drawable._6401669242106).into(imageView1);
        val imageView2 = findViewById<ImageView>(R.id.iv2);
        Glide.with(this).load("https://www.adslzone.net/app/uploads-adslzone.net/2021/08/xokas.jpg").into(imageView2);

    }

    fun showActivity(){
        Toast.makeText(this, "Activity Imágenes", Toast.LENGTH_LONG).show()
    }

    fun getAndShowName(){
        val bundle = intent.extras
        val name = bundle?.get("INTENT_NAME")
        val textView3 = findViewById<TextView>(R.id.textView3)
        textView3.text = "Bienvenido $name"
    }

    fun showMsgBtn(){
        Toast.makeText(this, "Hemos pulsado el botón 2 de la Actividad 2", Toast.LENGTH_SHORT).show()
    }
}