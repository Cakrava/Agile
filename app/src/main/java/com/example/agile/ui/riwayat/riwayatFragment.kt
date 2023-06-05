package com.example.agile.ui.riwayat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.agile.databinding.FragmentRiwayatBinding
import com.example.agile.ui.riwayat.RiwayatViewModel

class riwayatFragment : Fragment() {

    private var _binding: FragmentRiwayatBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val riwayatViewModel =
            ViewModelProvider(this).get(RiwayatViewModel::class.java)

        _binding = FragmentRiwayatBinding.inflate(inflater, container, false)
        val root: View = binding.root
//
//        val textView: TextView = binding.textRiwayat
//        riwayatViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}