package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidprojectshoppinglist.R
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistBinding

class ShoppinglistFragment : Fragment() {

    private lateinit var notificationsViewModel: ShoppinglistViewModel
    private var _binding: FragmentShoppinglistBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProvider(this)[ShoppinglistViewModel::class.java]

        _binding = FragmentShoppinglistBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textShoppinglist
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.top_shoppinglist_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_add_shoppinglist_item -> {
                findNavController().navigate(R.id.action_navigation_shoppinglist_to_shoppinglist_add_item_fragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}