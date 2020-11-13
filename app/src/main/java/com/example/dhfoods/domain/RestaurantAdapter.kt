package com.example.dhfoods.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dhfoods.R
import kotlinx.android.synthetic.main.item_restaurant.view.*

class RestaurantAdapter(var restaurantsList: List<Restaurant>, var listener: OnRestaurantItemClickListener): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>(){

    inner class RestaurantViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

        val imgRestaurante  = itemView.img_restaurante
        val nomeRestaurante = itemView.edt_nome_restaurante
        val enderecoRestaurante = itemView.edt_endereco_restaurante
        val horarioRestaurante = itemView.edt_horario_restaurante

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = adapterPosition
            if(position != RecyclerView.NO_POSITION)
                listener.OnClickRestaurant(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun getItemCount() = restaurantsList.size

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {

            var listItem = restaurantsList[position]

            holder.imgRestaurante.setImageResource(listItem.imagem)
            holder.nomeRestaurante.text = listItem.nome
            holder.enderecoRestaurante.text = listItem.endereco
            holder.horarioRestaurante.text = listItem.horarioFuncionamento
    }

    interface OnRestaurantItemClickListener {
        fun OnClickRestaurant(position: Int)

    }

}
