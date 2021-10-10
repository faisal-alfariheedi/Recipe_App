package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class view : AppCompatActivity() {
    lateinit var back: Button
    lateinit var tvtit: TextView
    lateinit var tving:TextView
    lateinit var tvins:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)
        init()
        tvtit.text=intent.getStringExtra("tit")
        tving.text=intent.getStringExtra("ing")
        tvins.text=intent.getStringExtra("ins")
        back.setOnClickListener{
            intent = Intent(applicationContext, MainActivity2::class.java)
            startActivity(intent)
        }

    }
    fun init(){
        back=findViewById(R.id.returnbut)
        tvtit=findViewById(R.id.tvtitle)
        tving=findViewById(R.id.tving)
        tvins=findViewById(R.id.tvins)
    }
}