package com.example.androidprojectshoppinglist.ui.waitingame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidprojectshoppinglist.databinding.FragmentWaitinggameBinding

class WaitinggameFragment : Fragment() {

    private lateinit var waitinggameViewModel: WaitinggameViewModel
    private var _binding: FragmentWaitinggameBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        waitinggameViewModel =
            ViewModelProvider(this)[WaitinggameViewModel::class.java]

        _binding = FragmentWaitinggameBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textWaitinggame
        waitinggameViewModel.text.observe(viewLifecycleOwner, {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}