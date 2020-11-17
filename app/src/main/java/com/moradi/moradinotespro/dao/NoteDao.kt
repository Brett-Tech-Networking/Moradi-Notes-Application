package com.moradi.moradinotespro.dao

import androidx.room.*
import com.moradi.moradinotespro.entities.Notes

@Dao
interface NoteDao {

@Query(  "SELECT *FROM notes ORDER BY id DESC")
suspend fun getAllNotes(): List<Notes>

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertNotes(note:Notes)

@Delete
suspend fun  deleteNote(note:Notes)

}