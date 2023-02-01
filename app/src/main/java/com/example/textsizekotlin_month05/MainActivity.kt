package com.example.textsizekotlin_month05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.textsizekotlin_month05.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: ViewModelText by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
        initListeners()
    }

    private fun observer() {
        viewModel.count.observe(this) { count ->
            binding.tv.text = count.toString()
        }
        viewModel.snackBar.observe(this){snack ->
            binding.btnIncrease.showSnackBar(snack.toString())
            binding.btnDecrease.showSnackBar(snack.toString())
        }
    }

    private fun initListeners() {
        binding.btnIncrease.setOnClickListener {
            viewModel.increase()
        }
        binding.btnDecrease.setOnClickListener {
            viewModel.decrease()
        }
    }
}