package com.example.androidprojectshoppinglist.data.shoppinglist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//https://github.com/googlecodelabs/android-room-with-a-view/tree/kotlin/app/src/main/java/com/example/android/roomwordssample
//done
@Database(entities = [ShoppingItem::class], version = 1, exportSchema = false)
abstract class ShoppinglistDatabase : RoomDatabase(){
    abstract val shoppinglistDatabaseDao : ShoppinglistDatabaseDao

    companion object{
        @Volatile
        private var INSTANCE: ShoppinglistDatabase? = null

        fun getInstance(context: Context) : ShoppinglistDatabase{
            synchronized(this){
                var instance = INSTANCE

                if(instance == null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        ShoppinglistDatabase::class.java,
                        "shoppinglist_table"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                    INSTANCE= instance
                }
                return instance
            }
        }

        /*
        fun getDatabase(context: Context, scope: CoroutineScope) : ShoppinglistDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ShoppinglistDatabase::class.java,
                    "shoppinglist_table"
                )
                .fallbackToDestructiveMigration()
                .addCallback(ShoppinglistDatabaseCallback(scope))
                .build()

                INSTANCE = instance
                //return instance
                instance
            }
        }

         */

        /*
        private class ShoppinglistDatabaseCallback(private val scope: CoroutineScope): RoomDatabase.Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.shoppinglistDatabaseDao)
                    }
                }
            }
        }

        suspend fun populateDatabase(shoppinglistDao: ShoppinglistDatabaseDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            shoppinglistDao.deleteAll()

            var shoppingItem = ShoppingItem(1,"Eggs", "Dairy", 12)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(2,"Cheese", "Dairy",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(3,"Sausages", "Meat",2)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(4,"Chicken", "Meat",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(5,"Banana", "Fruit",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(6,"Orange", "Fruit",5)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(7,"Fishsticks", "Meat",3)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(8,"Paper towels", "Cleaning",2)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(9,"Shampoo", "Care",2)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(10,"Corn flakes", "Cereals",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(11,"Beer", "Drinks",24)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(12,"Beer", "Drinks",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(13,"Beer", "Drinks",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(14,"Beer", "Drinks",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(15,"Beer", "Drinks",1)
            shoppinglistDao.insert(shoppingItem)
            shoppingItem = ShoppingItem(16,"Beer", "Drinks",1)
            shoppinglistDao.insert(shoppingItem)
        }
        */
    }
}