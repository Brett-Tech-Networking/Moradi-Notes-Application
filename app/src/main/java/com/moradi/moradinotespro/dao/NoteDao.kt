package com.moradi.moradinotespro.dao

import androidx.room.*
import com.moradi.moradinotespro.entities.Notes

@Dao
interface NoteDao {

@get:Query(  "SELECT *FROM notes ORDER BY id DESC")
val allNotes: List<Notes>

@Insert(onConflict = OnConflictStrategy.REPLACE)
suspend fun insertNotes(note:Notes)

@Delete
suspend fun  deleteNote(note:Notes)

}