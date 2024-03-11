package com.codetoanbug.workapp.di

import com.codetoanbug.workapp.WordRepository
import com.codetoanbug.workapp.WordRepositoryImpl
import com.codetoanbug.workapp.database.WordDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object WordsModule {
    @Provides
    fun provideWordRepository(wordDAO: WordDAO): WordRepository {
        return WordRepositoryImpl(wordDAO)
    }
}