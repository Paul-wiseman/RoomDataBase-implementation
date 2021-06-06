package com.wiseman.paul.androidroomdatabase.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.wiseman.paul.androidroomdatabase.model.Person
import com.wiseman.paul.androidroomdatabase.model.User

/*Contains the database holder and serves as the main access point for
the underlying connection to your app's persisted, relational data*/

@Database(entities = [User::class, Person::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    // this fun returns a user Dao
    abstract fun userDao(): UserDao

    // Everything within this companion object will be visible to other class
    companion object {
        // writes to this field is immediately visible to other threads
        @Volatile
        private var INSTANCE: UserDatabase? = null
        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
