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
import com.example.pil.data.Books
import com.example.pil.recycleView.BookRecycleViewAdapter


class Books : Fragment() {

    private val bookList = listOf(
        Books(
            title = "Alice no país das maravilhas",
            author = "Lewis Caroll",
            picture_max = R.drawable.min_alice_no_pais_das_maravilhas
        ),
        Books(
            title = "O mágico de Oz",
            author = "L.Frank Baum",
            picture_max = R.drawable.min_o_magico_de_oz
        ),
        Books(
            title = "Heidi",
            author = "Johanna Spyri",
            picture_max = R.drawable.min_heidi
        ),
        Books(
            title = "O pequeno príncipe",
            author = "Antoine de Saint-Exupéry",
            picture_max = R.drawable.min_o_pequeno_principe
        ),
        Books(
            title = "Peter Pan",
            author = "J. M. Barrie",
            picture_max = R.drawable.min_peter_pan
        ),
        Books(
            title = "A princesinha",
            author = "Frances Hodgson Burnett",
            picture_max = R.drawable.min_a_princesinha
        ),
        Books(
            title = "Os mais fantasticos contos de Grimm",
            author = "Wilhelm e Jacob Grimm",
            picture_max = R.drawable.min_os_mais_fantasticos_contos_de_grimm
        ),
        Books(
            title = "Reinações de narizinho",
            author = "Monteiro Lobato",
            picture_max = R.drawable.min_reinacoes_de_narizinho
        ),
        Books(
            title = "As caçadas de pedrinho",
            author = "Monteiro Lobato",
            picture_max = R.drawable.min_as_cacadas_de_pedrinho
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

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