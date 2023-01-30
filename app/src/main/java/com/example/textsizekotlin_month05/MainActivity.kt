package com.example.textsizekotlin_month05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.textsizekotlin_month05.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var diffPlus = 10.0f
    private var diffMinus = 0.0f
    private lateinit var viewModel :ViewModelText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initializeViewModel()
        initListeners()
    }

    private fun initializeViewModel() {
        viewModel = ViewModelProvider(this)[ViewModelText::class.java]
    }
    private fun initListeners() {
        viewModel.count.observe(this) { count ->
            binding.tv.text = count.toString()
        }
        binding.btnIncrease.setOnClickListener {
            if (binding.tv.text == diffPlus.toString())snackBarShow(it)
            else increase()
        }
        binding.btnDecrease.setOnClickListener {
            if (binding.tv.text==diffMinus.toString())snackBarShow(it)
            else decrease()
        }
    }
      private fun snackBarShow(view: View){
          val snackBar = Snackbar.make(view, "Вы достигли предела!",
              Snackbar.LENGTH_LONG)
          snackBar.show()
    }
      private fun increase(){
     viewModel.increase()
 }
      private fun decrease(){
        viewModel.decrease()
    }
}