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

        shoppinglistAddItemViewModel.initData()

        binding.fragmentShoppingItemAddButton.setOnClickListener{ view: View ->
            run {
                if(shoppinglistAddItemViewModel.submitForm()){
                    shoppinglistAddItemViewModel.createItem()
                    Navigation.findNavController(view).navigate(R.id.action_navigation_shoppinglist_add_item_fragment_to_navigation_shoppinglist)
                }
            }
        }

        shoppinglistAddItemViewModel.getFormViewStateLiveData().observe(viewLifecycleOwner, { viewState ->
            setFormViewState(viewState)
        })

        return binding.root
    }

    private fun setFormViewState(viewState: AddItemFormViewState) {
        binding.formViewState = viewState
        binding.executePendingBindings()
    }


}