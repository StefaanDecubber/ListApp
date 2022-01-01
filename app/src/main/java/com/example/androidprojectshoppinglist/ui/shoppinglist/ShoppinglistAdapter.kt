package com.example.androidprojectshoppinglist.ui.shoppinglist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprojectshoppinglist.data.shoppinglist.ShoppingItem
import com.example.androidprojectshoppinglist.databinding.FragmentShoppinglistItemBinding

class ShoppinglistAdapter : ListAdapter<ShoppingItem, ShoppinglistAdapter.ViewHolder>(ShoppingitemDiffCallback()) {
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val shoppingItem = getItem(position)
        holder.bind(shoppingItem)
        /*
        holder.itemView.setOnLongClickListener {
            deleteItem(position)
        }
        holder.shoppingListItemName.setOnLongClickListener {
            deleteItem(position)
        }
         */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    class ViewHolder private constructor(val binding: FragmentShoppinglistItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ShoppingItem){
            binding.shoppingitem = item
            binding.executePendingBindings()
        }
        companion object {
            fun from(parent: ViewGroup):ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = FragmentShoppinglistItemBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    /*
    var data = listOf<ShoppingItem>()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = data.size

    //TODO write a delete method to show a popup where you can confirm or cancel your delete
    fun deleteItem(position: Int): Boolean{
        showDeletePopup()
        return true
    }

    private fun showDeletePopup(){
        //val view = LayoutInflater.from()
        //return PopupWindow(R.layout.pop_up_window_delete_shopping_item, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
*/
}

class ShoppingitemDiffCallback : DiffUtil.ItemCallback<ShoppingItem>() {
    override fun areItemsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem.itemId == newItem.itemId
    }

    override fun areContentsTheSame(oldItem: ShoppingItem, newItem: ShoppingItem): Boolean {
        return oldItem == newItem
    }
}