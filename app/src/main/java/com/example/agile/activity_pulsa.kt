package com.example.agile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.agile.databinding.ActivityMainBinding

import com.example.agile.databinding.ActivityPulsaBinding
import com.example.agile.databinding.FragmentHomeBinding

class activity_pulsa : AppCompatActivity() {

    private lateinit var binding: ActivityPulsaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPulsaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.tombol.setOnClickListener {
            Toast.makeText(this, "buat testing ajaa", Toast.LENGTH_SHORT).show()
        }
    }
}
