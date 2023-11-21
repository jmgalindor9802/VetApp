package com.example.virtualvetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.virtualvetapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}