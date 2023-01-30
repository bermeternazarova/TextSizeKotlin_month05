package com.example.textsizekotlin_month05

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelText :ViewModel (){
    private  val _count = MutableLiveData<Float>()
    val count : LiveData<Float> =_count
    private var diff = 0.0f

    fun increase(){
        diff ++
        _count.value = diff
    }
    fun decrease(){
        diff --
        _count.value = diff
    }
}