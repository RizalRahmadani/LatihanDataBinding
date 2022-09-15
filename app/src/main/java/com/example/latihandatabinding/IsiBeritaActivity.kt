package com.example.latihandatabinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_isi_berita.*

class IsiBeritaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi_berita)

        var getDataBerita = intent.getSerializableExtra("isiBerita") as DataClassBerita
        imgIsi.setImageResource(getDataBerita.img)
        txtJudulIsi.text = getDataBerita.judul
        txtJurnalisIsi.text = getDataBerita.jurnalis
        txtTanggalIsi.text = getDataBerita.tanggal
        txtIsi.text = getDataBerita.isi
    }


}