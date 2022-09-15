package com.example.latihandatabinding

import java.io.Serializable

data class DataClassBerita(var img : Int, var judul : String, var jurnalis: String, var tanggal : String, var isi : String) : Serializable{
}