package com.codetoanbug.workapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "word_table")
data class Word(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val word: String
)
