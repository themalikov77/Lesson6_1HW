package com.example.lesson6_1hw

import android.content.Context
import android.widget.Toast

fun showToast(context : Context) {
    Toast.makeText(
        context,
        context.getString(R.string.isNotEmpty), Toast.LENGTH_SHORT
    ).show()
}