package com.example.dhfoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


private const val ARG_PARAM1 = "nome"
private const val ARG_PARAM2 = "descricao"
private const val ARG_PARAM3 = "imagem"

class FoodDetailFragment : Fragment() {

    private var nome: String? = null
    private var descricao: String? = null
    private var imagem: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            nome = it.getString(ARG_PARAM1)
            descricao = it.getString(ARG_PARAM2)
            imagem = it.getInt(ARG_PARAM3)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_food_detail, container, false)
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: Int) =
            FoodDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                    putInt(ARG_PARAM2, param3)
                }
            }
    }
}