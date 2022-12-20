package com.example.logintest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Home : Fragment() {

    private val bookList = listOf(
        Book(
            "Alice no país das maravilhas",
            "Lewis Caroll",
            "1865",
            "",
            R.drawable.min_alice_no_pais_das_maravilhas
        ),
        Book("O mágico de Oz", "L.Frank Baum", "1900", "", R.drawable.min_o_magico_de_oz),
        Book("Heidi", "Johanna Spyri", "1880", "", R.drawable.min_heidi),
        Book(
            "O pequeno príncipe",
            "Antoine de Saint-Exupéry",
            "2000",
            "",
            R.drawable.min_o_pequeno_principe
        ),
        Book("Peter Pan", "J. M. Barrie", "1911", "", R.drawable.min_peter_pan),
        Book("A princesinha", "Frances Hodgson Burnett", "1905", "", R.drawable.min_a_princesinha),
        Book(
            "Os mais fantasticos contos de Grimm",
            "Wilhelm e Jacob Grimm",
            "2021",
            "",
            R.drawable.min_os_mais_fantasticos_contos_de_grimm
        ),
        Book(
            "Reinações de narizinho",
            "Monteiro Lobato",
            "1931",
            "",
            R.drawable.min_reinacoes_de_narizinho
        ),
        Book(
            "As caçadas de pedrinho",
            "Monteiro Lobato",
            "1939",
            "",
            R.drawable.min_as_cacadas_de_pedrinho
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = activity?.intent?.getStringExtra("USERNAME")
        val textViewGreetings = view.findViewById<TextView>(R.id.textViewGreetings)

        textViewGreetings.text = "Bem vindo $username"

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewBook)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BookRecycleViewAdapter(bookList)

        val horizontalLayoutManagaer =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.layoutManager = horizontalLayoutManagaer
    }
}