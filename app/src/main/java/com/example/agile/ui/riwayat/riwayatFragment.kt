package com.example.agile.ui.riwayat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.agile.adapter.AdapterRiwayat
import com.example.agile.app.ApiConfig
import com.example.agile.R
import com.example.agile.model.RiwayatModel
import com.example.agile.model.ResponseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class riwayatFragment : Fragment() {

    private lateinit var rvRiwayat: RecyclerView
    private lateinit var riwayatAdapter: AdapterRiwayat
    private val listRiwayat: ArrayList<RiwayatModel> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_riwayat, container, false)
        initView(view)
        getRiwayat()
        return view
    }

    private fun initView(view: View) {
        rvRiwayat = view.findViewById(R.id.recycler_view)
        riwayatAdapter = AdapterRiwayat(requireActivity(), listRiwayat)
        rvRiwayat.layoutManager = LinearLayoutManager(activity)
        rvRiwayat.adapter = riwayatAdapter
    }

    private fun getRiwayat() {
        ApiConfig.instanceRetrofit.getRiwayat().enqueue(object : Callback<ResponseModel> {

            override fun onResponse(
                call: Call<ResponseModel>,
                response: Response<ResponseModel>
            ) {
                if (response.isSuccessful) {
                    val res = response.body()
                    if (res != null) {
                        listRiwayat.clear()
                        listRiwayat.addAll(res.riwayat)
                        riwayatAdapter.notifyDataSetChanged()
                    } else {
                        Toast.makeText(
                            requireActivity(),
                            "Empty response body",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        requireActivity(),
                        "Response unsuccessful",
                        Toast.LENGTH_LONG
                    ).show()
                }
            }

            override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                Toast.makeText(
                    requireActivity(),
                    "Error: ${t.message}",
                    Toast.LENGTH_LONG
                ).show()
            }
        })
    }
}
