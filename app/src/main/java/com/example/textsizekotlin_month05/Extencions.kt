package com.example.textsizekotlin_month05

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun View.showSnackBar(message :String){
    val snackBar = Snackbar.make(this,message, Snackbar.LENGTH_SHORT)
    snackBar.show()
}