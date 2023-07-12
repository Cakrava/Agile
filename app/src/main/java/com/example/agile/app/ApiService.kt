package com.example.agile.app

import com.example.agile.model.RiwayatModel
import com.example.agile.model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("riwayat")
    fun getRiwayat(): Call<ResponseModel>
}
