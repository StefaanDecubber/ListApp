package com.example.androidprojectshoppinglist.ui.shoppinglistAddItem

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.androidprojectshoppinglist.R
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistAddItemBinding
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistBinding

class ShoppinglistAddItemFragment : Fragment() {

    private lateinit var shoppinglistAddItemViewModel: ShoppinglistAddItemViewModel
    private var _binding: FragmentShoppinglistAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        shoppinglistAddItemViewModel = ViewModelProvider(this)[ShoppinglistAddItemViewModel::class.java]
        _binding = FragmentShoppinglistAddItemBinding.inflate(inflater, container, false)


        binding.fragmentShoppingItemAddButton.setOnClickListener{ view: View ->
            Navigation.findNavController(view).navigate(R.id.action_navigation_shoppinglist_add_item_fragment_to_navigation_shoppinglist)
        }

        return binding.root
    }


}