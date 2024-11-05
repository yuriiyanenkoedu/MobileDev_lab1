package com.example.lab_1

import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.lab_1.databinding.ActivityMainBinding

class MainActivity : ComponentActivity() {
    private val textViewModel: MainViewModel by viewModels()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        textViewModel.text.observe(this) { newText ->
            binding.textView.text = newText
        }

        var textToChange : String = "world"
        var flag : Boolean = true
        binding.button.setOnClickListener{
            textViewModel.changeText(textToChange)
            textToChange = if (flag) "Hello" else "world"
            flag = !flag
        }
    }

}



