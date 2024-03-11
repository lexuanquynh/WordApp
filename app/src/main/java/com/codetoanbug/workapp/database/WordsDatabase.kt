package com.codetoanbug.workapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.codetoanbug.workapp.model.Word

@Database(entities = [Word::class], exportSchema = false, version = 1)
abstract class WordsDatabase: RoomDatabase() {
    abstract fun wordDAO(): WordDAO
}