package com.moradi.moradi_notes_premium.dao

import androidx.room.*
import com.moradi.moradi_notes_premium.entities.Notes

@Dao
interface NoteDao{

    @Query(  "SELECT *FROM notes ORDER BY id DESC")
    suspend fun getAllNotes(): List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNotes(note:Notes)

    @Delete
    suspend fun  deleteNote(note:Notes)

}