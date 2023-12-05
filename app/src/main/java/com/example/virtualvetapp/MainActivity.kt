package com.example.virtualvetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.virtualvetapp.OpenHelper.OpenHelper
import com.example.virtualvetapp.OpenHelper.Usuario
import com.example.virtualvetapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.doc.requestFocus()

        binding.btnAceptar.setOnClickListener {Autenticar(binding)
        }
    }
    fun Register(view: View){
        val intent=Intent(this,RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun Autenticar(binding:ActivityMainBinding){
         var error=false
        if(binding.doc.text.isEmpty()){
            error = true
            binding.doc.error="Debe digitar un documento"
            return
        }
        if(binding.pwd.text.isEmpty()){
            error=true
            binding.pwd.error="Debe especificar una contraseña"
            return
        }
        if(!error) {
            val doc = binding.doc.text.toString().toInt()
            val pwd = binding.pwd.text.toString()
            val db = OpenHelper(this)
            val user = db.validarUsuario(doc, pwd)

            if (user != null) {
                val usuario = Usuario(
                    user.getInt(0),
                    user.getInt(1),
                    user.getString(2),
                    user.getString(3),


                    )
                val intent=Intent(this,MenuActivity::class.java)
                intent.putExtra(MenuActivity.USER, usuario)
                startActivity(intent)
                this.finish()

            }else{
                Toast.makeText(this,"Documento y/o constraseña no válido",Toast.LENGTH_SHORT)

            }

        }
    }
}