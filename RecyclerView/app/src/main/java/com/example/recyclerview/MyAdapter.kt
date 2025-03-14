package com.example.recyclerview

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private var newsArrayList: ArrayList<News>, var context : Activity):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

        private lateinit var myListener: OnItemClickListener

        interface OnItemClickListener {
            fun onItemClicking(position: Int)
        }

        fun setItemClickListener(listener: OnItemClickListener){
            myListener = listener
        }

    //to create new view instance, when layout manager fails to find a suitable view for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.each_row,parent, false)
        return MyViewHolder(itemView, myListener)
    }

    // populate items with data
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
        val currentItem = newsArrayList[position]
        holder.hTitle.text = currentItem.newsHeading
        holder.hImage.setImageResource(currentItem.newsImage)
    }

    // how many list items are present in your array
    override fun getItemCount(): Int {
        return newsArrayList.size
    }

    // It holds the view so views are not created everytime, so memory can be saved
    class MyViewHolder(itemView: View, listener: OnItemClickListener) : RecyclerView.ViewHolder(itemView) {
        val hTitle = itemView.findViewById<TextView>(R.id.headingTitle)
        val hImage = itemView.findViewById<ShapeableImageView>(R.id.headingImage)

        init {
            itemView.setOnClickListener {
                listener.onItemClicking(adapterPosition)
            }
        }
    }
}
