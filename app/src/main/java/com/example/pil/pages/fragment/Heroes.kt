package com.example.pil.pages.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.HeroRecycleViewAdapter
import com.example.pil.R
import com.example.pil.data.Hero

class Heroes : Fragment() {

    private val heroList = listOf<Hero>(
        Hero("Thor", "Deus do trovão", R.drawable.thor),
        Hero("Homem-formiga", "Encolher ou fica gigante", R.drawable.homem_formiga),
        Hero("Homem-aranha", "Soltar teia, agilidade", R.drawable.homem_aranha),
        Hero("Batman", "Inteligência", R.drawable.batman),
        Hero("Doutor estranho", "Magia", R.drawable.doutor_estranho),
        Hero("Viúva negra", "Agilidade, luta", R.drawable.viuva_negra),
        Hero("Feiticeira escarlate", "Magia", R.drawable.feiticeira_escarlate),
        Hero("Hulk", "Força", R.drawable.hulk),
        Hero("Capitão américa", "Luta, agilidade, escudo", R.drawable.capitao_america)
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hero, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewHero)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = HeroRecycleViewAdapter(heroList)

        val horizontalLayoutManagaer =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManagaer
    }
}