package com.example.agile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
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


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @SuppressLint("SuspiciousIndentation")
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
//        ---------------------------------Taruh kode tambahan di bawah--------------------------------------

//------------ini adalah toas untuk nomor-----------------
  val btn_toast_nomor=findViewById<Button>(R.id.btn_toast_nomor)
        btn_toast_nomor.setOnClickListener {
            Toast.makeText(this, "Nomor anda sudah terverifikasi!", Toast.LENGTH_SHORT).show()
        }

//------------membuka aktivity kota nelpon-----------
        val btnCall=findViewById<Button>(R.id.btn_call)
        btnCall.setOnClickListener {
            val intent = Intent(this, activity_kuota_call::class.java)
            startActivity(intent)
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
//        -----------------ini batas akhir---------

    }
}
//---------------------kelas fragmen home-----------------------------

