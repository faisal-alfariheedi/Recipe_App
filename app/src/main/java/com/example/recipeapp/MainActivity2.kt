package com.example.recipeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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
        init()
        but.setOnClickListener{
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)

        }
        if (apif != null) {
            apif.getRecipies()?.enqueue(object : Callback<List<recipe.dat>> {
                override fun onResponse(call: Call<List<recipe.dat>>, response: Response<List<recipe.dat>>) {
                    Log.d("message body", response.body()!![1].title!!)
                    for (i in response.body()!!) {

                        res.add(i)

                    }
                    rv.adapter?.notifyDataSetChanged()
                    wait(false)

                }

                override fun onFailure(call: Call<List<recipe.dat>>, t: Throwable) {

                    wait(false)
                    Toast.makeText(applicationContext, t.message, Toast.LENGTH_SHORT).show();
                }
            })
        }

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