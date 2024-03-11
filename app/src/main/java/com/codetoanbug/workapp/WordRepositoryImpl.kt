package com.codetoanbug.workapp

import androidx.lifecycle.LiveData
import com.codetoanbug.workapp.database.WordDAO
import com.codetoanbug.workapp.model.Word

class WordRepositoryImpl(
    private val wordDAO: WordDAO
) : WordRepository {
    override suspend fun insert(word: Word) {
        wordDAO.insert(word)
    }

    override fun getAllWords(): LiveData<List<Word>> {
        return wordDAO.getAllWords()
    }
}