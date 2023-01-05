package com.example.pil.pages.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.R
import com.example.pil.data.BookListMock
import com.example.pil.recycleView.BookRecycleViewAdapter


class Books : Fragment() {

    private val bookList = BookListMock().bookList

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var spinnerFilterBook = view.findViewById<Spinner>(R.id.spinnerFilterBook)
        var searchViewBooks = view.findViewById<SearchView>(R.id.searchViewBooks)

        ArrayAdapter.createFromResource(
            view.context,
            R.array.filter_options,
            android.R.layout.simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerFilterBook.adapter = adapter
        }

        searchViewBooks.setOnQueryTextFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                spinnerFilterBook.visibility = View.GONE
            } else {
                spinnerFilterBook.visibility = View.VISIBLE
            }
        }

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleViewBookList)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BookRecycleViewAdapter(bookList)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
    }
}