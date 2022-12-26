package com.example.pil.recycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.R
import com.example.pil.data.Books

class BookRecycleViewAdapter(private val bookList: List<Books>) :
    RecyclerView.Adapter<BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItem = layoutInflater.inflate(R.layout.list_item_books, parent, false)
        return BookViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = bookList[position]
        holder.textViewBookName.text = book.title
        holder.textViewBookAuthor.text = book.author
        holder.imageViewBookMax.setBackgroundResource(book.picture_max)
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
}

class BookViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val textViewBookName: TextView = view.findViewById(R.id.textViewBookTitleListItemBooks)
    val textViewBookAuthor: TextView = view.findViewById(R.id.textViewBookAuthorListItemBooks)
    val imageViewBookMax: ImageView = view.findViewById(R.id.imageViewListItemBook)
}