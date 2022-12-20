package com.example.logintest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookRecycleViewAdapter(private val bookList: List<Book>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var listItem = layoutInflater.inflate(R.layout.list_item_book, parent, false);
        return BookViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.textViewBookName.text = book.title
        holder.textViewBookAuthor.text = book.author
        holder.imageViewBookMin.setBackgroundResource(book.picture_min)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}

class BookViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textViewBookName: TextView = view.findViewById(R.id.textViewBookTitle)
    val textViewBookAuthor : TextView = view.findViewById(R.id.textViewBookAuthor)
    val imageViewBookMin: ImageView = view.findViewById(R.id.imageViewBookMin)
}
