package com.example.agile.app

import com.example.agile.model.RiwayatModel
import com.example.agile.model.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @FormUrlEncoded
    @POST("tblProduk/save")
    fun saveBarang(
        @Body data: RiwayatModel
    ): Call<ResponseModel>

    @GET("barang")
    fun getBarang(): Call<ResponseModel>
}
