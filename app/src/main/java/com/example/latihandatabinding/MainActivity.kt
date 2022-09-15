package com.example.latihandatabinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.latihandatabinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), AdapterBerita.ItemClickListener {
        lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val listBerita = arrayListOf(
            DataClassBerita(R.drawable.kpu, "KPU Siap Jika Diadukan ke PTUN oleh 9 Parpol Tak Lolos Pemilu 2024", "Karin Nur Secha", "13 Sep 2022 16:56 WIB", "Bawaslu tak meloloskan sembilan partai politik ke proses pendaftaran Pemilu 2024. Menanggapi hal tersebut, Ketua Divisi Hukum dan Pengawasan KPU RI, Mochammad Afifuddin menyebut jika apa yang dilakukan KPU saat proses pendaftaran sudah benar.\"Artinya sudah benar apa yang dilakukan oleh KPU dalam proses pendaftaran kemarin,\" ujar Afifuddin saat ditemui usai sidang di Kantor Bawaslu, Jakarta Pusat, Selasa (13/9/2022). Kemudian, Afifuddin menyebut pihaknya juga siap mengantisipasi adanya sejumlah partai yang mungkin nantinya melaporkan KPU ke PTUN atas dugaan pelanggaran maladministrasi. Namun, kata dia, sampai saat ini pihaknya belum menerima adanya laporan ke PTUN.\n" +
                    "\"Mau nggak mau kan (harus dihadapi). Semuanya harus dihadapi resiko itu. Tapi yang pasti kita sudah melakukan dengan prosedur yang memang sudah kita siapkan,\" jelas Afifuddin.\"Ya itu resiko. harus kita siap hadapi yang pasti dari 9 kasus yang naik ke persidangan paling tidak majelis sudah memutuskan tidak ada pelanggaran administrasi sama sekali yang dilakukan kpu dan semoga proses ke depannya semakin baik,\" sambungnya. Diketahui, Bawaslu telah menggelar sidang putusan atas laporan dugaan pelanggaran administrasi yang dilakukan KPU. Bawaslu menyatakan KPU tidak melakukan pelanggaran administrasi tentang tata cara pendaftaran parpol.\n" +
                    "Sidang ini digelar di kantor Bawaslu, Jl MH Thamrin, Jakpus, Selasa (13/9), dan dipimpin oleh Ketua Majelis Pemeriksa Puadi. Bawaslu menyatakan KPU telah sesuai terkait tata cara, prosedur dan mekanisme yang telah diatur sesuai perundang-undangan.\n"),
            DataClassBerita(R.drawable.brigadir, "Disanksi Demosi 2 Tahun Terkait Kasus Sambo, Brigadir Frillyan Tak Banding", "Azhar Bagas Ramadhan ", "14 Sep 2022 13:21 WIB", "Brigadir Frillyan Fitri Rosadi (FF) dijatuhi sanksi demosi 2 tahun karena terbukti tidak profesional terkait kasus pembunuhan Brigadir Nopriansyah Yosua Hutabarat (Brigadir J). Brigadir Frillyan tak mengajukan banding atas putusan tersebut."),
            DataClassBerita(R.drawable.pengacara,"Pihak Putri Candrawathi Jelaskan Fungsi Rekening Khusus Bripka RR-Brigadir J","Azhar Bagas Ramadhan","14 Sep 2022 12:38 WIB","Pengacara Putri Candrawathi, Arman Hanis, menjelaskan fungsi rekening khusus yang dibuat untuk para ajudan Irjen Ferdy Sambo. Rekening itu, menurut Arman, dibuat untuk keperluan tugas masing-masing ajudan."),
            DataClassBerita(R.drawable.sambo,"Terungkap Alasan Ferdy Sambo Kumpulkan Bawahan Usai Bunuh Brigadir J","tim detikNews ", "14 Sep 2022 05:46 WIB", "Terungkap alasan mantan Kadiv Propam Irjen Ferdy Sambo mengumpulkan bawahannya di Provos usai pembunuhan Brigadir Nofriansyah Yosua Hutabarat atau Brigadir J. Seperti diungkapkan pengacara Bripka Ricky Rizal (RR), Erman Umar." ),
            DataClassBerita(R.drawable.img, "Melihat Isi Garasi Menteri 'Termiskin' di Kabinet Jokowi","Tim detikOto","13 Sep 2022 05:00 WIB", "Menteri Koperasi dan UKM pada Kabinet Indonesia Maju, Teten Masduki, memiliki harta kekayaan Rp 4.289.787.787. Meski berharta miliaran, Teten masuk dalam daftar menteri Jokowi 'termiskin'. Berdasarkan penelusuran dari laman Laporan Kekayaan Penyelenggaran Negara (LHKPN) untuk seluruh menteri, harta yang dimiliki Teten memang yang paling sedikit."),
            DataClassBerita(R.drawable.img_1,"TNI Buka Rekrutmen Perwira Prajurit Karier 2022, Lulusan D4-S2 Merapat!","Tim detikFinance","12 Sep 2022 13:05 WIB", "Peluang terbuka bagi detikers yang ingin berkarier menjadi bagian dari Tentara Nasional Indonesia (TNI). Saat ini, TNI tengah membuka penerimaan Perwira Prajurit Karier (Pa PK) reguler tahun angkatan (TA) 2022. Dinukil dari laman resmi Rekrutmen TNI (Senin, 12/9/2022), pendaftaran ini dibuka dari 9 September 2022 hingga 21 Oktober 2022."),
            DataClassBerita(R.drawable.anies,"Bulan Depan Lengser dari Gubernur DKI, Anies Dapat Uang Pensiun Segini","Ignacio Geordi Oswaldo","14 Sep 2022 13:33 WIB","Masa jabatan Gubernur DKI Jakarta Anies Baswedan akan selesai pada Oktober 2022 mendatang,. Anies sempat berkelakar bahwa dirinya mungkin tidak akan memperpanjang masa jabatannya."),
            DataClassBerita(R.drawable.img_2, "Terkuak Motif Hacker Bjorka Serang Indonesia!", "Tim detiknet", "11 Sep 2022 22:25 WIB","Hacker Bjorka mengungkapkan motifnya menyerang sistem Pemerintah Indonesia. Bjorka membeberkan motif dari aksinya itu lantaran orang terdekatnya menjadi korban kebijakan Orde Baru pasca 1965"),
            DataClassBerita(R.drawable.img_3,"Berulah lagi, hacker Bjorka senggol Puan Maharani-Erick Thohir!","Tim detiknet","11 Sep 2022 17:48 WIB","Hacker Bjorka kembali membuat gempar Indonesia. Tak cukup membocorkan data pribadi warga Indonesai hingga dokumen Presiden Jokowi hingga Badan Intelijen Negara (BIN), kini ia turut menyenggol para pejabat tinggi Indonesia"),
            DataClassBerita(R.drawable.img_4,"Diduga karena obat nyamuk, rumah pensiunan pns di jembrana terbakar","I Ketut Suardika","14 Sep 2022 14:14 WIB","Satu unit rumah milik warga seorang pensiunan PNS di Desa Gumbrig ludes terbakar, pada selasa (13/9/2022) sekitar pukul 12.10 Wita. Kebakaran diduga karena obat nyamuk bakar yang dinyalakan pada senin malam sejak pukul 23.00 Wita.")

        )
        binding.rvBerita.adapter = AdapterBerita(listBerita, this)
        binding.rvBerita.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        }

    override fun onItemClicked(detail: DataClassBerita){
        var pindah = Intent(this, IsiBeritaActivity::class.java)
        pindah.putExtra("isiBerita",detail)
        startActivity(pindah)

    }


    }

