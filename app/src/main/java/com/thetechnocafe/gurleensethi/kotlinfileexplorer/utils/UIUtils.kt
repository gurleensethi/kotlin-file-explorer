package com.thetechnocafe.gurleensethi.kotlinfileexplorer.utils

import android.graphics.Color
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.TextView

fun View.createShortSnackbar(message: String) {
    val snackbar = Snackbar.make(this, message, Snackbar.LENGTH_SHORT)
    val textView = snackbar.view.findViewById<TextView>(android.support.design.R.id.snackbar_text)
    textView.setTextColor(Color.WHITE)
    snackbar.show()
}