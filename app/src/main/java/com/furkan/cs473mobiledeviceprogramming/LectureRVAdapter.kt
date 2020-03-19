package com.furkan.cs473mobiledeviceprogramming

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView

class LectureRVAdapter(var context: Context, var lectures: ArrayList<Lecture>) :
    RecyclerView.Adapter<LectureRVAdapter.MyViewHolder>() {

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.t1.text = lectures.get(position).name

        holder.parentlayout.setOnClickListener {

            var activity: AppCompatActivity = it.context as AppCompatActivity
            val fragment = AssignmentDetailFragment()
            val bundle = Bundle()
            bundle.putString("key", lectures.get(position).pdfUrl)
            fragment.setArguments(bundle)
            activity.supportFragmentManager.beginTransaction().replace(R.id.mainLayout, fragment).addToBackStack(null).commit()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.card_layout, parent, false)
        return MyViewHolder(v);
    }

    override fun getItemCount(): Int {
        return lectures.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var t1: TextView = itemView.findViewById<TextView>(R.id.tv1)
        var parentlayout: LinearLayout = itemView.findViewById(R.id.playout) as LinearLayout
    }

}