package com.example.logintest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeroRecycleViewAdapter(val heroList:List<Hero>) : RecyclerView.Adapter<HeroViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        var listItem = layoutInflater.inflate(R.layout.list_item_hero, parent, false);
        return HeroViewHolder(listItem)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.textViewHeroName.text = hero.name
        holder.textViewHeroHabilities.text = hero.habilities
        holder.imageViewHeroImage.setBackgroundResource(hero.picture)
    }

    override fun getItemCount(): Int {
        return heroList.size
    }
}

class HeroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    val textViewHeroName = view.findViewById<TextView>(R.id.textViewBookTitle)
    val textViewHeroHabilities = view.findViewById<TextView>(R.id.textViewBookAuthor)
    val imageViewHeroImage = view.findViewById<ImageView>(R.id.imageViewBookMin)
}
