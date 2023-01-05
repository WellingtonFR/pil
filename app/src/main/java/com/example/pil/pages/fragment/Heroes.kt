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
import com.example.pil.data.BookListMock
import com.example.pil.data.Hero
import com.example.pil.data.HeroListMock

class Heroes : Fragment() {

    private val heroList = HeroListMock().heroList

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