package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.androidprojectshoppinglist.R
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabase
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabaseDao
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistBinding

class ShoppinglistFragment : Fragment() {
    private lateinit var shoppinglistViewModel: ShoppinglistViewModel
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
        _binding = FragmentShoppinglistBinding.inflate(inflater, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = ShoppinglistDatabase.getInstance(application).shoppinglistDatabaseDao
        val viewModelFactory = ShoppinglistViewModelFactory(dataSource, application)
        val shoppinglistViewModel = ViewModelProvider(this, viewModelFactory)[ShoppinglistViewModel::class.java]

        binding.shoppinglistViewModel = shoppinglistViewModel
        binding.lifecycleOwner = this
        return binding.root
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