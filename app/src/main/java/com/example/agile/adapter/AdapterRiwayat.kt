package com.example.agile.adapter
import android.annotation. SuppressLint
import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.agile.R
import com.example.agile.model.RiwayatModel
import com.squareup.picasso.Picasso import kotlin.collections.ArrayList

class AdapterRiwayat (var activity: Activity, var data: ArrayList<RiwayatModel>): RecyclerView.Adapter<AdapterRiwayat.Holder>() {
    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val tvharga = view.findViewById<TextView>(R.id.tvharga)
        val tvkategori = view.findViewById<TextView>(R.id.tvkategori)
        val tvtanggal = view.findViewById<TextView> (R.id.tvtanggal)
      val tvkuota = view.findViewById<TextView> (R.id.tvkuota)
    }

    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        context = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.rcl_riwayat, parent,false)
        return Holder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: Holder, position: Int) {
        val a = data[position]
        holder.tvharga.text = a.harga
        holder.tvkategori.text = a.kategori
        holder.tvtanggal.text=a.tanggal
        holder.tvkuota.text=a.kuota

    }

    override fun getItemCount(): Int {
        return data.size
    }
}