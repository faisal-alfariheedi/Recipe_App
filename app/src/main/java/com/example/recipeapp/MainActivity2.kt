package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity2 : AppCompatActivity() {
    lateinit var rv: RecyclerView
    lateinit var but: Button
    lateinit var apif: APIInterface
    var res: ArrayList<recipe.dat> = arrayListOf()
    lateinit var prog: ProgressBar
    lateinit var tvw: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

    }
    fun init() {
        but = findViewById(R.id.addres)
        rv = findViewById(R.id.rvma)
        rv.adapter = RVAdapter(res,this)
        rv.layoutManager = LinearLayoutManager(this)
        apif = APIClient().getClient()?.create(APIInterface::class.java)!!
        tvw=findViewById(R.id.wait)
        prog=findViewById(R.id.progressBar)
        wait(true)
    }
    fun wait(a:Boolean){
        if(a){
            prog.isVisible = true
            tvw.isVisible = true
        }else{
            prog.isVisible=false
            tvw.isVisible=false
        }

    }
}