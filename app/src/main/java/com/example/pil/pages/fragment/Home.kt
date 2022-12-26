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
import com.example.pil.data.Books

class Home : Fragment() {

    private val bookList = listOf(
        Books(
            "Alice no país das maravilhas",
            "Lewis Caroll",
            "1865",
            "",
            R.drawable.min_alice_no_pais_das_maravilhas
        ),
        Books("O mágico de Oz", "L.Frank Baum", "1900", "", R.drawable.min_o_magico_de_oz),
        Books("Heidi", "Johanna Spyri", "1880", "", R.drawable.min_heidi),
        Books(
            "O pequeno príncipe",
            "Antoine de Saint-Exupéry",
            "2000",
            "",
            R.drawable.min_o_pequeno_principe
        ),
        Books("Peter Pan", "J. M. Barrie", "1911", "", R.drawable.min_peter_pan),
        Books("A princesinha", "Frances Hodgson Burnett", "1905", "", R.drawable.min_a_princesinha),
        Books(
            "Os mais fantasticos contos de Grimm",
            "Wilhelm e Jacob Grimm",
            "2021",
            "",
            R.drawable.min_os_mais_fantasticos_contos_de_grimm
        ),
        Books(
            "Reinações de narizinho",
            "Monteiro Lobato",
            "1931",
            "",
            R.drawable.min_reinacoes_de_narizinho
        ),
        Books(
            "As caçadas de pedrinho",
            "Monteiro Lobato",
            "1939",
            "",
            R.drawable.min_as_cacadas_de_pedrinho
        )
    )

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