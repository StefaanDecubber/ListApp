package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistItemBinding
import android.provider.ContactsContract.CommonDataKinds.Note
import java.util.ArrayList







class ShoppinglistAdapter(private val listener: OnItemClickListener) : ListAdapter<ShoppingItem, ShoppinglistAdapter.ViewHolder>(ShoppingitemDiffCallback()) {

    private lateinit var shoppinglist : List<ShoppingItem>

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingItem = getItem(position)
        holder.bind(shoppingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = FragmentShoppinglistItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    inner class ViewHolder(val binding: FragmentShoppinglistItemBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.apply {
                shoppinglistItemName.setOnClickListener{
                    val position = adapterPosition
                    if(position != RecyclerView.NO_POSITION){
                        val shoppingItem = getItem(position)
                        listener.onCheckBoxClick(shoppingItem, shoppinglistItemName.isChecked)
                    }
                }
            }
        }

        fun bind(item: ShoppingItem) {
            binding.shoppingitem = item
            binding.executePendingBindings()
        }

        fun getChecked(): Boolean {
            val checked = binding.shoppinglistItemName
            return checked.isChecked
        }

    }
    interface OnItemClickListener {
        fun onCheckBoxClick(shoppingItem: ShoppingItem, isChecked: Boolean)
    }

}

class ShoppingitemDiffCallback : DiffUtil.ItemCallback<ShoppingItem>() {
    override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem == newItem
    }
}