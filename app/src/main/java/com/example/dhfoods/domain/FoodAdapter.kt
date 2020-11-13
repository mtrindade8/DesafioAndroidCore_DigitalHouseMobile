package com.example.dhfoods.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dhfoods.R
import kotlinx.android.synthetic.main.item_food.view.*


class FoodAdapter(var foodList: List<Food>, var listener: OnFoodItemClickListener): RecyclerView.Adapter<FoodAdapter.FoodViewHolder>(){

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val imageFood  = itemView.img_food
        val nomeFood = itemView.edt_nome_food

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.OnClickFood(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun getItemCount() = foodList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {

        var listItem = foodList[position]

        holder.imageFood.setImageResource(listItem.imagem)
        holder.nomeFood.text = listItem.nome
    }

    interface OnFoodItemClickListener {
        fun OnClickFood(position: Int)
    }

}
