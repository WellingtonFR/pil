package com.example.pil.pages.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.pil.R
import com.example.pil.pages.activity.Login
import com.example.pil.pages.activity.Main

class AccountManager : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val buttonLogout = view.findViewById<Button>(R.id.buttonLogout)

        buttonLogout.setOnClickListener {
            val intent = Intent(context, Login::class.java)
            startActivity(intent)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_account_manager, container, false)
    }
}