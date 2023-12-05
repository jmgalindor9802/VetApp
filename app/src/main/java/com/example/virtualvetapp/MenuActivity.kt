package com.example.virtualvetapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.virtualvetapp.OpenHelper.Usuario
import com.example.virtualvetapp.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    companion object{
        const val USER="MenuActivity:user"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMenuBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user=intent.getParcelableExtra<Usuario>(USER)
        binding.txtNomUsr.text="Bienvenid@ \n" + user?.nombre;
        Glide.with(this).
        load("https://i.pinimg.com/originals/86/f8/56/86f85682cf485f993dbc8fde7126152c.gif").
        into(binding.perrito)
        Glide.with(this).
        load("https://i.pinimg.com/originals/95/3d/93/953d93400bd763401c60db27f4e29373.gif").
        into(binding.patico)
        Glide.with(this).
        load("https://www.gifsanimados.org/data/media/209/gato-imagen-animada-0368.gif").
        into(binding.gatico)
        Glide.with(this).
        load("https://i.pinimg.com/originals/3c/86/a0/3c86a010293a9467ed80ad046878f082.gif").
        into(binding.pajarito)

        binding.perrito.setOnClickListener {
            Toast.makeText(this,"He hecho click sobre el perrito", Toast.LENGTH_LONG)
        }
        binding.gatico.setOnLongClickListener {
            Toast.makeText(this,"He hecho click sostenido sobre el gatico",Toast.LENGTH_LONG)
            true
        }

    }
}