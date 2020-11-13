package com.example.dhfoods

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController

class RestaurantActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurant)

        val extras = intent.extras
        val nomeRestaurante = extras?.getString("nome")
        val imagemRestaurante = extras?.getInt("imagem")

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_container_restaurant, RestaurantDetailFragment.newInstance(nomeRestaurante as String, imagemRestaurante as Int))
            commit()
        }

    }
}