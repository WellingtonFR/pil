package com.example.pil.pages.fragment

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.pil.R

class BookDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bookTitle = view.findViewById<TextView>(R.id.textViewBookDetailsTitle)
        val bookAuthor = view.findViewById<TextView>(R.id.textViewBookDetailsAuthor)
        val bookCover = view.findViewById<ImageView>(R.id.imageViewBookDetailsBookCover)

        var title: String? = ""
        var author: String? = ""
        var coverImage: Int = 1

        val args = this.arguments
        args?.let {
            title = args.getString("title")
            author = args.getString("author")
            coverImage = args.getInt("coverImage")
        }

        bookTitle.text = title
        bookAuthor.text = author
        bookCover.setBackgroundResource(coverImage)

    }
}