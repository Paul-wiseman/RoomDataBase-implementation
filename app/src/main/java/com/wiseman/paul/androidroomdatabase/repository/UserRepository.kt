package com.wiseman.paul.androidroomdatabase.repository

import androidx.lifecycle.LiveData
import com.wiseman.paul.androidroomdatabase.data.UserDao
import com.wiseman.paul.androidroomdatabase.model.Person
import com.wiseman.paul.androidroomdatabase.model.User

/*A repository class abstracts access to multiple data sources.
* The repository is not part of the Architecture Components libraries but is a suggested best practice for
* code separation and architecture*/
class UserRepository(private val userDao: UserDao) {
    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }

    suspend fun updateUser(user: User){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: User){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUser(){
        userDao.deleteAllUsers()
    }
    val readPerson: LiveData<List<Person>> = userDao.readPerson()

    suspend fun insertPerson(person: Person){
        userDao.insertPerson(person)
    }
}