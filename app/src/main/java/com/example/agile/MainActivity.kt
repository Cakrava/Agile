package com.example.agile

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ScrollView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.agile.databinding.ActivityMainBinding
import com.example.agile.databinding.FragmentHomeBinding
import com.example.agile.util.pref


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val navView: BottomNavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_notifications, R.id.navigation_akun, R.id.navigation_riwayat
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        //unutk loign
        navView.setupWithNavController(navController)
        navView.setOnNavigationItemSelectedListener { item ->
            if (item.itemId == R.id.navigation_akun) {
                val s = pref(this)
                if (s.getISlogin()) {
                    Log.d("TAG", "SUDAH LOGIN")
                    // Navigasi ke halaman navigation_akun
                    navController.navigate(R.id.navigation_akun)
                    true
                } else {
                    startActivity(Intent(this, ActivityLogin::class.java))
                    Log.d("TAG", "Belum Login, pindah ke halaman login")
                    false
                }
            } else {
                Log.d("TAG", "onCreate yg Lain" + item.itemId)
                navController.navigate(item.itemId)
                true
            }
        }





//        ---------------------------------Taruh kode tambahan di bawah--------------------------------------

//------------ini adalah toas untuk nomor-----------------
  val btn_toast_nomor=findViewById<Button>(R.id.btn_toast_nomor)
        btn_toast_nomor.setOnClickListener {
            Toast.makeText(this, "Nomor anda sudah terverifikasi!", Toast.LENGTH_SHORT).show()
        }

//------------membuka aktivity kota nelpon-----------
//        val btnCall=findViewById<Button>(R.id.btn_call)
//        btnCall.setOnClickListener {
//            val intent = Intent(this, activity_kuota_call::class.java)
//            startActivity(intent)
//        }
        // Pada Activity yang sesuai, misalnya MainActivity
        val button = findViewById<Button>(R.id.btn_call)
        button.setOnClickListener {
            val s = pref(this)
            if (s.getISlogin()) {
                // Jika sudah login, langsung navigasi ke ActivityKuotaCall
                startActivity(Intent(this, activity_kuota_call::class.java))
            } else {
                // Jika belum login, pindah ke halaman login terlebih dahulu
                startActivity(Intent(this, ActivityLogin::class.java))
            }
        }

//        logout
        val btnExit = findViewById<Button>(R.id.btn_baru)
        btnExit.setOnClickListener {
            val pref = getSharedPreferences("Mypref", Context.MODE_PRIVATE)
            val editor = pref.edit()
            editor.clear()
            editor.apply()

            // Pindah ke Fragment Home setelah logout
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish() // Mengakhiri activity saat ini agar tidak bisa kembali tanpa login ulang
        }
//        --------------ini embuka aktivity kuota internet------
        val btnGB=findViewById<Button>(R.id.btn_gb)
        btnGB.setOnClickListener {
            val intent = Intent(this, activity_kuota_internet::class.java)
            startActivity(intent)
        }

//        -------ini membuka aktivity pulsa-----------
        val btnPulsa=findViewById<Button>(R.id.btn_pulsa)
        btnPulsa.setOnClickListener {
            val intent = Intent(this, activity_pulsa::class.java)
            startActivity(intent)
        }

//        nilai nilai isi
        val pref = pref(this)
        val txtpulsa = findViewById<TextView>(R.id.txtpulsa)
        val koin = findViewById<TextView>(R.id.txtkoin)
        val selamatdatang = findViewById<TextView>(R.id.txtSelamatDatang)
        val sejak = findViewById<TextView>(R.id.sejak)
        val nomor = findViewById<Button>(R.id.btn_toast_nomor)
        val hari = findViewById<TextView>(R.id.tvhari)
        val level = findViewById<TextView>(R.id.tvlevel)
        val scrhorizontal = findViewById<HorizontalScrollView>(R.id.scrhorizontal)

        if (pref.getISlogin()) {
            // Jika sudah login
            txtpulsa.text = "Rp.50000"
            koin.text = "240 Poin"
            selamatdatang.text = "Selamat Datang, Joyo!"
            sejak.text = "Sejauh ini kamu sudah membeli hingga Rp.360.000!"
            nomor.text = "082297068911"
            hari.text = "187"
            level.text = "12"
            scrhorizontal.visibility = View.VISIBLE

        } else {
            // Jika belum login
            txtpulsa.text = "Rp.0"
            koin.text = "0 Poin"
            selamatdatang.text = "Harap Login!"
            sejak.text = "_"
            nomor.text = "-"
            hari.text = "-"
            level.text = "-"
            scrhorizontal.visibility = View.GONE

        }




//        -----------------ini batas akhir---------

    }
}
//---------------------kelas fragmen home-----------------------------

