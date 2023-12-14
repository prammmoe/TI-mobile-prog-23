package com.example.metricv2.ui.menu.trends

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.metricv2.R
import com.example.metricv2.data.remote.response.MealCategory

class TrendsAdapter(private val list: List<MealCategory>): RecyclerView.Adapter<TrendsAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val categoryTitle: TextView = view.findViewById(R.id.text_category)
        val image: ImageView = view.findViewById(R.id.img_content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food_content, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.categoryTitle.text = list[position].strMeal
        Glide.with(holder.itemView.context)
            .load(list[position].strMealThumb)
            .into(holder.image)
    }
}