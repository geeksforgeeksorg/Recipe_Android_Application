package com.example.recipeapp.ui.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recipeapp.R
import com.example.recipeapp.ui.details.RecipeDetailActivity
import com.example.recipeapp.models.Meal

class RecipeAdapter(
    private val context: Context,
    private val meals: List<Meal>
) : RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageView: ImageView = itemView.findViewById(R.id.mealImage)
        val textView: TextView = itemView.findViewById(R.id.mealName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = meals[position]
        Glide.with(context).load(item.strMealThumb).into(holder.imageView)
        holder.textView.text = item.strMeal

        holder.itemView.setOnClickListener {
            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra("MEAL_ID", item.idMeal)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = meals.size
}