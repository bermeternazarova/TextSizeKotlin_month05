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
        initializeViewModel()
        initListeners()
    }
    private fun initializeViewModel() {
      //  viewModel = ViewModelProvider(this)[ViewModelText::class.java]
    }
    private fun initListeners() {
        viewModel.count.observe(this) { count ->
            binding.tv.text = count.toString()
        }
        binding.btnIncrease.setOnClickListener {
            viewModel.increase(it)
        }
        binding.btnDecrease.setOnClickListener {
            viewModel.decrease(it)
        }
    }
}