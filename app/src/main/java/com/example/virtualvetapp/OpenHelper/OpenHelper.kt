package com.example.virtualvetapp.OpenHelper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
const val DataBase ="Usuarios.db"
class OpenHelper(context: Context) : SQLiteOpenHelper(context,DataBase,null,1){
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = "CREATE TABLE usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "doc INTEGER NOT NULL,"+
                "nombre VARCHAR(50) NOT NULL,"+
                "pass VARCHAR(15) NOT NULL)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }


    fun guardarUsuario(user: Usuario):String{
        val db=this.writableDatabase
        val con = ContentValues()
        con.put("doc",user.doc)
        con.put("nombre",user.nombre)
        con.put("pass",user.pass)

        var res=db.insert("usuario",null, con)

        if(res==-1L){
            return "Error en la inserción de usuario"
        }else{
            return "Usuario creado exitosamente"
        }

    }

    fun validarUsuario(doc:Int,pas:String): Cursor?{
        val sql = "SELECT * FROM usuario WHERE doc = $doc AND pass = $pas"
        val db= this.readableDatabase
        var res = db.rawQuery(sql,null)

        if(res.moveToFirst()){
            return res
        }else{
            return null
        }

    }

}