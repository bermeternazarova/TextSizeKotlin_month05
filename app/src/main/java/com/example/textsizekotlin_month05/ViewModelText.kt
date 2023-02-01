package com.example.textsizekotlin_month05

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelText @Inject constructor(): ViewModel (){
    private  val _count = MutableLiveData<Float>()
    val count : LiveData<Float> =_count
    private var diff = 0.0f
    private val diffMinus = 0.0f
    private var diffPlus = 10.0f
    private var _snackBar = MutableLiveData<String>()
    val snackBar : LiveData<String> = _snackBar

    fun increase(){
        if (diff ==diffPlus)  _snackBar.value = "Вы достигли предела 10.0!"
        else {
            diff++
            _count.value = diff
        }
    }
    fun decrease(){
        if (diff ==diffMinus) _snackBar.value = "Вы достигли предела 0.0!"
        else{
            diff --
            _count.value = diff
        }
    }
}