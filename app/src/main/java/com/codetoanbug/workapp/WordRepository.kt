package com.codetoanbug.workapp

import androidx.lifecycle.LiveData
import com.codetoanbug.workapp.model.Word

interface WordRepository {
    suspend fun insert(word: Word)
    fun getAllWords(): LiveData<List<Word>>
}