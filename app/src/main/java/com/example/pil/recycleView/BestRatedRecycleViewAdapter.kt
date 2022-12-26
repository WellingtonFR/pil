package com.example.pil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.data.Books

class BestRatedRecycleViewAdapter(private val bookList: List<Books>) : RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var listItem = layoutInflater.inflate(R.layout.best_rated_books, parent, false);
        return BookViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.textViewBookName.text = book.title
        holder.imageViewBookMin.setBackgroundResource(book.picture_min)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewBookName: TextView = view.findViewById(R.id.textViewBookTitle)
    val imageViewBookMin: ImageView = view.findViewById(R.id.imageViewBookMin)
}
