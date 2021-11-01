package com.example.contentproviderassignment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*

class MyHolder(itemVIew: View) : RecyclerView.ViewHolder(itemVIew) {
    fun setData(mess: Mess)
    {
        itemView.name.text=mess.id
        itemView.number.text=mess.txt
    }
}