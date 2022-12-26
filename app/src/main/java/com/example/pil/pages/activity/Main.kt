package com.example.pil.pages.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.pil.R
import com.example.pil.databinding.ActivityMainBinding
import com.example.pil.pages.fragment.AccountManager
import com.example.pil.pages.fragment.Books
import com.example.pil.pages.fragment.Heroes
import com.example.pil.pages.fragment.Home


class Main : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(Home())

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home_item -> replaceFragment(Home())
                R.id.book_item -> replaceFragment(Books())
                R.id.heroes_item -> replaceFragment(Heroes())
                R.id.settings_item -> replaceFragment(AccountManager())
                else -> {false}
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}