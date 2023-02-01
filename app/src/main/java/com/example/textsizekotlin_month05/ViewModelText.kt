package com.example.textsizekotlin_month05

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelText @Inject constructor(): ViewModel (){
    private  val _count = MutableLiveData<Float>()
    val count : LiveData<Float> =_count

    private var _snack = MutableLiveData<Snackbar>()
    val snack : LiveData<Snackbar> = _snack

    private var diff = 0.0f
    private var diffPlus = 10.0f
    private var diffMinus = 0.0f

    fun increase(view: View){
        val snackBar = Snackbar.make(view,"Вы достигли предела",Snackbar.LENGTH_SHORT)
        if (diff== diffPlus) {
            snackBar.show()
            _snack.value = snackBar
        }else{
            diff ++
            _count.value = diff
        }
    }
    fun decrease(view: View){
        val snackBar = Snackbar.make(view,"Вы достигли предела",Snackbar.LENGTH_SHORT)
        if (diff == diffMinus){
            snackBar.show()
            _snack.value=snackBar
        }else{
            diff --
            _count.value = diff
        }
    }
}