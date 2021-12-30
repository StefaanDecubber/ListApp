package com.example.androidprojectshoppinglist.data.shoppinglist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//https://github.com/googlecodelabs/android-room-with-a-view/tree/kotlin/app/src/main/java/com/example/android/roomwordssample
@Entity(tableName = "shoppinglist_table")
data class ShoppingItem(
    @PrimaryKey(autoGenerate = true)
    var itemId:Long = 0L,
    @ColumnInfo(name = "name")
    var item: String = "",
    @ColumnInfo(name = "category")
    var category: String,
    @ColumnInfo(name = "quantity")
    var quantity: Int){

}
