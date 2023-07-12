package com.example.agile.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class pref(activity: Activity) {

    private var sp: SharedPreferences? = null
    private val login = "Login"

    init {
        sp = activity.getSharedPreferences("Mypref", Context.MODE_PRIVATE)
    }

    fun setISlogin(value: Boolean) {
        sp!!.edit().putBoolean(login, value).apply()
    }

    fun getISlogin(): Boolean {
        return sp!!.getBoolean(login, false)
    }
}
