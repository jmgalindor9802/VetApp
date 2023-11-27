package com.example.virtualvetapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.virtualvetapp.OpenHelper.OpenHelper
import com.example.virtualvetapp.OpenHelper.Usuario
import com.example.virtualvetapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnReg.setOnClickListener {
            guardar(binding)
        }
    }
    private fun guardar(binding: ActivityRegisterBinding){
        var error= false
        if(binding.txtdoc.text.isEmpty()){
            error=true
            binding.txtdoc.error="Debe especificar un documento"
            return
        }
        if(binding.txtnom.text.isEmpty()){
            error=true
            binding.txtdoc.error="Debe especificar un nombre"
            return
        }
        if(binding.txtpwd.text.isEmpty()){
            error=true
            binding.txtpwd.error="Debe especificar una contraseña"
            return
        }
        if(binding.txtpwdconf.text.isEmpty()){
            error=true
            binding.txtpwdconf.error="Debe confirmar la contraseña"
            return
        }
        if(!binding.txtpwd.text.toString().equals(binding.txtpwdconf.text.toString())){
            error=true
            binding.errorpwd.visibility= View.VISIBLE
            return
        }
        if(!error){
            val usuario = Usuario(
                null,
                binding.txtdoc.text.toString().toInt(),
                binding.txtnom.toString(),
                binding.txtpwd.text.toString()
            )
            val openHelper=OpenHelper(this)
            val msg = openHelper.guardarUsuario(usuario)
            Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }

}