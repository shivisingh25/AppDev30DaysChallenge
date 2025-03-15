package com.example.api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class ProductAdapter(private val context : Activity, private val productArrayList: List<Product>) :
 RecyclerView.Adapter<ProductAdapter.ProductViewHolder>(){

 override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
     val itemView = LayoutInflater.from(context).inflate(R.layout.eachproduct,parent,false)
     return ProductViewHolder(itemView)
 }

 override fun getItemCount(): Int {
     return productArrayList.size
 }

 override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
     val currentItem = productArrayList[position]
      holder.title.text = currentItem.title
      // image view, how to show image in image view if the image is in form of url
       // 3rd Party Library i.e. Picasso
     Picasso.get().load(currentItem.thumbnail).into(holder.image)
     holder.rating.rating = currentItem.rating.toFloat()

 }

 class ProductViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
  var title : TextView
  var image : ShapeableImageView
  var rating : RatingBar

  init {
   title = itemView.findViewById(R.id.productTitle)
   image = itemView.findViewById(R.id.productImage)
    rating = itemView.findViewById(R.id.productRating)
  }
 }
}