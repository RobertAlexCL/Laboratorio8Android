package com.example.lab5

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class adaptor(var list: ArrayList<row>):RecyclerView.Adapter<adaptor.ViewHolder>(){



    override fun onBindViewHolder(p0: adaptor.ViewHolder, p1: Int) {
        p0.bindItem(list[p1])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        var v = LayoutInflater.from(p0.context).inflate(R.layout.item,p0,false)
        return ViewHolder(v)
    }

    class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        fun bindItem(data:row){
            val name: TextView = itemView.findViewById(R.id.nomProducto)
            val q: TextView = itemView.findViewById(R.id.q)
            name.text = data.product.name
            q.text = data.q.toString()
            val sub: Button = itemView.findViewById(R.id.plus)
            val plus: Button = itemView.findViewById(R.id.sub)

            plus.setOnClickListener(){
                var num = data.q+1
                data.q = num
                q.text=num.toString()
            }

            sub.setOnClickListener(){
                if(data.q!=0){
                    var num = data.q-1
                    data.q = num
                    q.text=num.toString()
                }
            }
        }
    }
}