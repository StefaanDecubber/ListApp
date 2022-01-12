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
import androidx.core.widget.doOnTextChanged
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.androidprojectshoppinglist.R
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppinglistDatabase
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistAddItemBinding
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistBinding
import com.example.androidprojectshoppinglist.ui.shoppinglist.ShoppinglistViewModel
import com.example.androidprojectshoppinglist.ui.shoppinglist.ShoppinglistViewModelFactory

class ShoppinglistAddItemFragment : Fragment() {

    private lateinit var shoppinglistAddItemViewModel: ShoppinglistAddItemViewModel
    private var _binding: FragmentShoppinglistAddItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val application = requireNotNull(this.activity).application
        val dataSource = ShoppinglistDatabase.getInstance(application).shoppinglistDatabaseDao
        val viewModelFactory = ShoppinglistAddItemViewModelFactory(dataSource, application)
        shoppinglistAddItemViewModel = ViewModelProvider(this, viewModelFactory)[ShoppinglistAddItemViewModel::class.java]
        _binding = FragmentShoppinglistAddItemBinding.inflate(inflater, container, false)
        binding.shoppinglistAddItemViewModel = shoppinglistAddItemViewModel

        binding.textInputEditTextItemname.doOnTextChanged{text, start, before, count ->
            if(!Validators.validateItemname(text!!.toString()))
                binding.textInputEditTextItemname.error = "Moet ingevuld zijn"
            else
                binding.textInputEditTextItemname.error = null
        }

        binding.textInputEditTextCategory.doOnTextChanged{text, start, before, count ->
            if(!Validators.validateCategory(text!!.toString()))
                binding.textInputEditTextCategory.error = "Moet ingevuld zijn"
            else
                binding.textInputEditTextCategory.error = null
        }

        binding.textInputEditTextQuantity.doOnTextChanged{text, start, before, count ->
            if(!Validators.validateQuantity(text!!.toString()))
                binding.textInputEditTextQuantity.error = "Moet een getal zijn tussen 1 en 100"
            else
                binding.textInputEditTextQuantity.error = null
        }


        binding.fragmentShoppingItemAddButton.setOnClickListener{
            val validationForm = Validators.validateForm(
                binding.textInputEditTextItemname.text.toString(),
                binding.textInputEditTextCategory.text.toString(),
                binding.textInputEditTextQuantity.text.toString()
            )
            if(validationForm){
                shoppinglistAddItemViewModel.createItem(
                    binding.textInputEditTextItemname.text.toString(),
                    binding.textInputEditTextCategory.text.toString(),
                    binding.textInputEditTextQuantity.text.toString()
                )
                findNavController().navigate(R.id.action_navigation_shoppinglist_add_item_fragment_to_navigation_shoppinglist)
            }
        }

        return binding.root
    }



}