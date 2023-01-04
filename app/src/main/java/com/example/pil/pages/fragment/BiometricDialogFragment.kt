package com.example.pil.pages.fragment

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.pil.R

class BiometricDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setMessage(R.string.dialog_biometric_start)
                .setPositiveButton(R.string.dialog_biometric_positive) { dialog, id -> }
                .setNegativeButton(R.string.dialog_biometric_negative) { dialog, id -> }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}