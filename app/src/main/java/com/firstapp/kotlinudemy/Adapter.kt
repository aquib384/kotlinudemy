package com.firstapp.kotlinudemy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.kotlinudemy.model.Model

internal class Adapter(private var userList: List<Model>) :
        RecyclerView.Adapter<Adapter.MyViewHolder>() {
    internal inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.userId)
        var age: TextView = view.findViewById(R.id.title)
        var sex: TextView = view.findViewById(R.id.body)
    }
    @NonNull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.example, parent, false)
        return MyViewHolder(itemView)
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]
        holder.name.text = user.getUserId().toString()
        holder.age.text = user.getTitle()
        holder.sex.text = user.getBody()
    }
    override fun getItemCount(): Int {
        return userList.size
    }
}