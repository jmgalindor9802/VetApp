package com.example.virtualvetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.virtualvetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doc.requestFocus()

        binding.btnAceptar.setOnClickListener {  }
    }
    fun Register(view: View){
        val intent=Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }
}