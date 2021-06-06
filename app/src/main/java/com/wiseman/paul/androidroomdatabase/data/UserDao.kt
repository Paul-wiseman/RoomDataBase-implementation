package com.wiseman.paul.androidroomdatabase.data

import com.wiseman.paul.androidroomdatabase.model.Person
import androidx.lifecycle.LiveData
import androidx.room.*
import com.wiseman.paul.androidroomdatabase.model.User

/*UserDao: Data Access Object
* contains all the methods used for accessing the database*/
@Dao
interface UserDao {
    // inside this interface we create all the necessary query that will be executed inside the database

    /*The onConflict Strategy is used to state what is to be done if there are conflicting items, i.e items with same name
    * the ignore strategy is called so as to ignore conflicting id*/
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    /*this function is for fetching all data from the database and the table is specified and the order
    * the order is by id Asynchronously
    * the response is wrapped in a live data or stored in a live data*/
    @Query("SELECT * FROM user_table ORDER BY id ASC")
    fun readAllData(): LiveData<List<User>>

    // updating the user information
    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Query("DELETE FROM user_table")
    suspend fun deleteAllUsers()

    @Query("SELECT * FROM my_table ORDER BY id ASC")
    fun readPerson(): LiveData<List<Person>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPerson(person: Person)
}
