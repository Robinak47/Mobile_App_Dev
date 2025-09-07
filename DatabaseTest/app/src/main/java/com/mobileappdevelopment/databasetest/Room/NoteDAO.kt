package com.mobileappdevelopment.databasetest.Room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.mobileappdevelopment.databasetest.Model.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {

    @Insert
    suspend fun insert(note: Note)
    @Update
    suspend fun update(note: Note)
    @Delete
    suspend fun delete(note: Note)

    @Query("Delete from note_table")
    suspend fun deleteAllNote()

    @Query("Select * from note_table ORDER BY id ASC")
    fun getAllNote(): Flow<List<Note>>
}