package com.example.contentproviderassignment

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(var context: Context,var list: ArrayList<Mess>): RecyclerView.Adapter<MyHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        var view=LayoutInflater.from(context).inflate(R.layout.item,parent,false)
        return MyHolder(view)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        var sms=list.get(position)
        holder.setData(sms)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}