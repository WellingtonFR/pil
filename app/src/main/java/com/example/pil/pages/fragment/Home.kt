package com.example.pil.pages.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.BestRatedRecycleViewAdapter
import com.example.pil.R
import com.example.pil.data.Book
import com.example.pil.data.BookListMock

class Home : Fragment() {

    private val bookList = BookListMock().bookList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = activity?.intent?.getStringExtra("USERNAME")
        val textViewGreetings = view.findViewById<TextView>(R.id.textViewGreetings)

        textViewGreetings.text = "Bem vindo $username"

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBookBestRated)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BestRatedRecycleViewAdapter(bookList)

        val horizontalLayoutManagaer =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManagaer
    }
}