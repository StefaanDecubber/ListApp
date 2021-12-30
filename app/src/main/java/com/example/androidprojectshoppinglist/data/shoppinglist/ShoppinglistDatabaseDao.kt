package com.example.androidprojectshoppinglist.data.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow

//https://github.com/googlecodelabs/android-room-with-a-view/tree/kotlin/app/src/main/java/com/example/android/roomwordssample
//done
@Dao
interface ShoppinglistDatabaseDao {

    @Insert
    fun insert(item: ShoppingItem)

    @Update
    fun update(item: ShoppingItem)

    @Query("SELECT * FROM shoppinglist_table WHERE itemId = :key")
    fun get(key: Long): ShoppingItem

    @Delete
    fun delete(item: ShoppingItem)

    @Delete
    fun deleteAllItems(items: List<ShoppingItem>):Int

    @Query("SELECT * FROM shoppinglist_table ORDER BY category DESC")
    fun getAllItems(): List<ShoppingItem>

    /*
    @Query("DELETE FROM shoppinglist_table")
    suspend fun deleteAll()
     */
}