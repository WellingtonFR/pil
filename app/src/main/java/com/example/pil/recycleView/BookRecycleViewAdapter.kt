package com.example.pil.recycleView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.pil.R
import com.example.pil.data.Book
import com.example.pil.pages.fragment.BookDetails

class BookRecycleViewAdapter(private val bookList: List<Book>) :
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

        holder.itemView.setOnClickListener { v ->
            val activity = v!!.context as AppCompatActivity
            val bookDetails = BookDetails()
            val bundle = Bundle()
            bundle.putString("title", book.title)
            bundle.putString("author", book.author)
            bundle.putInt("coverImage", book.picture_max)
            bookDetails.arguments = bundle
            activity.supportFragmentManager
                .beginTransaction()
                .replace(R.id.frame_layout, bookDetails)
                .addToBackStack(null)
                .commit()
        }

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