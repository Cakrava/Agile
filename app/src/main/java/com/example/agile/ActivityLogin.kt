package com.example.agile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.agile.util.pref

class ActivityLogin : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button

    private lateinit var pref: pref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        pref = pref(this)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (username == "Joyokilatmoko" && password == "joyokilatmoko123") {
                pref.setISlogin(true)
                // Lanjutkan ke halaman selanjutnya atau lakukan tindakan lain setelah login berhasil
            } else {
                pref.setISlogin(false)
                // Tampilkan pesan login gagal atau lakukan tindakan lain jika login gagal
            }
        }
    }
}
