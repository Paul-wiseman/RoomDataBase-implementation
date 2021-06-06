package com.wiseman.paul.androidroomdatabase.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.wiseman.paul.androidroomdatabase.data.UserDatabase
import com.wiseman.paul.androidroomdatabase.model.Person
import com.wiseman.paul.androidroomdatabase.repository.UserRepository
import com.wiseman.paul.androidroomdatabase.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/*The ViewModel's role is to provide data to the UI and
survive configuration changes. A ViewModel acts as a communication
center between the Repository and the UI */
class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    private val repository: UserRepository
    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }
    val readPerson: LiveData<List<Person>> = repository.readPerson

    fun insertPerson(person: Person){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPerson(person)
        }
    }
    fun addUser(user: User) {
        viewModelScope.launch {
            repository.addUser(user)
        }
    }

    fun updateUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateUser(user)
        }
    }

    fun deleteUser(user: User){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteUser(user)
        }
    }

    fun deleteAllUser(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUser()
        }
    }
}