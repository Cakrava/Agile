package com.example.agile.ui.notif

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.agile.databinding.FragmentNotifBinding
import com.example.agile.databinding.FragmentRiwayatBinding
import com.example.agile.ui.notif.notifViewModel

class notifFragment : Fragment() {

    private var _binding: FragmentNotifBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notifFragment =
            ViewModelProvider(this).get(notifViewModel::class.java)

        _binding = FragmentNotifBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}