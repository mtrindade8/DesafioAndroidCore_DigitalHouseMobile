package com.example.dhfoods

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.recyclerview.widget.RecyclerView
import com.example.dhfoods.domain.Restaurant
import com.example.dhfoods.domain.RestaurantAdapter
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), RestaurantAdapter.OnRestaurantItemClickListener {

    val listaRestaurantes = getAllRestaurants()
    val adapter = RestaurantAdapter(listaRestaurantes, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        var recyclerView = findViewById<RecyclerView>(R.id.rcv_restaurante)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }

    fun getAllRestaurants() = mutableListOf<Restaurant>(
        Restaurant(1, "Tony Roma's", "Av. Lavandisca, 717 - Indianópolis, São Paulo", "Fecha às 22:00", R.drawable.image1),
        Restaurant(2, "Aoyama - Moema", "Alameda dos Arapanés, 532 - Moema", "Fecha às 00:00", R.drawable.image4),
        Restaurant(3, "Outback - Moema", "Av. Moaci, 187, 187 - Moema, São Paulo", "Fecha às 00:00", R.drawable.image5),
        Restaurant(4, "Sí Señor!", "Alameda Jauaperi, 626 - Moema", "Fecha às 01:00", R.drawable.image3),
    )

    fun callRestaurantActivity(position: Int){

        var restaurante = listaRestaurantes[position]
        val bundle = bundleOf("imagem" to restaurante.imagem, "nome" to restaurante.nome)
        var intent = Intent(this, RestaurantActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    override fun OnClickRestaurant(position: Int) {
        callRestaurantActivity(position)
    }
}
