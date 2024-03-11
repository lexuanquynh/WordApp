package com.codetoanbug.workapp


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.codetoanbug.workapp.model.Word
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordsViewModel @Inject constructor(
    private val repository: WordRepository
): ViewModel() {
    fun insertWord(word: String) = liveData {
        try {
            repository.insert(Word(id = 0, word = word))
            emit(true)
        } catch (e: Exception) {
            emit(false)
        }
    }

    fun getAllWords() = repository.getAllWords()
}