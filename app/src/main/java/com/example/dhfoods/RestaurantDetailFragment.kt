package com.example.dhfoods

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dhfoods.domain.Food
import com.example.dhfoods.domain.FoodAdapter
import com.example.dhfoods.domain.RestaurantAdapter
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.fragment_restaurant_detail.*
import kotlinx.android.synthetic.main.fragment_restaurant_detail.view.*

private const val ARG_PARAM1 = "nome"
private const val ARG_PARAM2 = "imagem"

class RestaurantDetailFragment : Fragment(), FoodAdapter.OnFoodItemClickListener {

    private var nome: String? = null
    private var imagem: Int? = null

    val listaFood = getAllFoods()
    val adapter = FoodAdapter(listaFood, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nome = it.getString(ARG_PARAM1)
            imagem = it.getInt(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_restaurant_detail, container, false)

        imagem?.let { view.img_restaurante_fragment.setImageResource(it) }
        view.txt_restaurante_fragment.text = nome


        var recyclerView = view.findViewById<RecyclerView>(R.id.rcv_food_fragment)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: Int) =
            RestaurantDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putInt(ARG_PARAM2, param2)
                }
            }
    }

    fun getAllFoods() = mutableListOf<Food>(
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
        Food(R.drawable.image4, "Salada com molho Gengibre", "Sed ut perspiciatis, unde omnis iste natus error sit voluptatem accusant doloremque laudantium, totam rem aperiam eaque ipsa, quae ab illo inventore veritatis."),
    )

    override fun OnClickFood(position: Int) {
            (activity as RestaurantActivity?)!!.replaceFragment(listaFood[position])
        }
}
