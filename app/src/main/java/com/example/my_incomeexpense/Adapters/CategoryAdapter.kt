package com.example.my_incomeexpense.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.income_expence.model.CategoryModel
import com.example.my_incomeexpense.R


class CategoryAdapter(val context: Context,val list :ArrayList<CategoryModel>) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : ViewHolder(itemView)
    {
        var txtCategory = itemView.findViewById<TextView>(R.id.txtCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.category_item,parent,false)
        return  CategoryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return  list.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.txtCategory.text = list.get(position).name
    }
}