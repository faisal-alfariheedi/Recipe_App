package com.example.recipeapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class RVAdapter(private val rv: ArrayList<recipe.dat>, val cont: Context): RecyclerView.Adapter<RVAdapter.ItemViewHolder>()  {
    class ItemViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ItemViewHolder {
        return RVAdapter.ItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.rvlist,parent,false )
        )
    }

    override fun onBindViewHolder(holder: RVAdapter.ItemViewHolder, position: Int) {
        val rvv = rv[position].title
        val rvvd= rv[position].author
        holder.itemView.apply {
            var rvlisting= findViewById<CardView>(R.id.rvlisting)
            var ct= findViewById<TextView>(R.id.cardtitle)
            var cd= findViewById<TextView>(R.id.carddesc)
            ct.text = rvv.toString()
            cd.text = rvvd.toString()
            rvlisting.setOnClickListener {

                var intent = Intent(cont, view::class.java)
                intent.putExtra("tit",rv[position].title)
                intent.putExtra("ing",rv[position].ingredients)
                intent.putExtra("ins",rv[position].instructions)
                context.startActivity(intent)

            }



        }
    }

    override fun getItemCount() = rv.size
}