package com.example.agile.ui.notif

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class notifViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "ini adalah Notif"
    }
    val text: LiveData<String> = _text
}