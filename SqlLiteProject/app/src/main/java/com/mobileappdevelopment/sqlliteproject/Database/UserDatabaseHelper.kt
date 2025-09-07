package com.mobileappdevelopment.sqlliteproject.Database
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.mobileappdevelopment.sqlliteproject.Model.User

class UserDatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "UserDB.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "users"
        private const val COL_ID = "id"
        private const val COL_USERNAME = "username"
        private const val COL_PASS = "password"
        private const val COL_ROLE = "role"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createTable = """
            CREATE TABLE $TABLE_NAME (
                $COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COL_USERNAME TEXT,
                $COL_PASS TEXT,
                $COL_ROLE TEXT
            )
        """
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(user: User): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_USERNAME, user.username)
            put(COL_PASS, user.password)
            put(COL_ROLE, user.role)
        }
        return db.insert(TABLE_NAME, null, values)
    }

    fun getAllUsers(): List<User> {
        val users = mutableListOf<User>()
        val db = readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow(COL_ID))
                val username = cursor.getString(cursor.getColumnIndexOrThrow(COL_USERNAME))
                val password = cursor.getString(cursor.getColumnIndexOrThrow(COL_PASS))
                val role = cursor.getString(cursor.getColumnIndexOrThrow(COL_ROLE))
                users.add(User(id, username, password, role))
            } while (cursor.moveToNext())
        }
        cursor.close()
        return users
    }

    fun updateUser(user: User): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COL_USERNAME, user.username)
            put(COL_PASS, user.password)
            put(COL_ROLE, user.role)
        }
        return db.update(TABLE_NAME, values, "$COL_ID=?", arrayOf(user.id.toString()))
    }

    fun deleteUser(id: Int): Int {
        val db = writableDatabase
        return db.delete(TABLE_NAME, "$COL_ID=?", arrayOf(id.toString()))
    }
}