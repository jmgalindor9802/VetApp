package com.example.virtualvetapp.OpenHelper

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(
    var id: Int?,
    var doc: Int,
    var nombre: String,
    var pass: String
    ): Parcelable