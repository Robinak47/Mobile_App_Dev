package com.mobileappdevelopment.sqlliteproject.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mobileappdevelopment.sqlliteproject.Model.User
import com.mobileappdevelopment.sqlliteproject.Repository.UserRepository


class UserViewModel(private val repo: UserRepository) : ViewModel() {

    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users

    fun insertUser(user: User) {
        repo.insertUser(user)
        loadUsers()
    }

    fun loadUsers() {
        _users.value = repo.getAllUsers()
    }

    fun updateUser(user: User) {
        repo.updateUser(user)
        loadUsers()
    }

    fun deleteUser(id: Int) {
        repo.deleteUser(id)
        loadUsers()
    }
}