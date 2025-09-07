package com.mobileappdevelopment.sqlliteproject.Repository

import com.mobileappdevelopment.sqlliteproject.Database.UserDatabaseHelper
import com.mobileappdevelopment.sqlliteproject.Model.User

class UserRepository(private val dbHelper: UserDatabaseHelper) {

    fun insertUser(user: User): Long = dbHelper.insertUser(user)

    fun getAllUsers(): List<User> = dbHelper.getAllUsers()

    fun updateUser(user: User): Int = dbHelper.updateUser(user)

    fun deleteUser(id: Int): Int = dbHelper.deleteUser(id)
}