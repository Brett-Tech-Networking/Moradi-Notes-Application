package com.moradi.moradi_notes_premium.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.moradi.moradi_notes_premium.CreateNoteFragment
import com.moradi.moradi_notes_premium.dao.NoteDao
import com.moradi.moradi_notes_premium.entities.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class NotesDatabase: RoomDatabase() {

    companion object{
        var notesDatabase:NotesDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): NotesDatabase {
            if(notesDatabase == null) {
                notesDatabase = Room.databaseBuilder(
                    context
                    , NotesDatabase::class.java
                    ,  "notes.db"
                ).build()
            }
            return notesDatabase!!
        }
    }
    abstract fun noteDao():CreateNoteFragment
}