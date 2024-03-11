package com.codetoanbug.workapp.database

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    @Provides
    fun provideWordsDatabase(@ApplicationContext context: Context): WordsDatabase {
        return Room.databaseBuilder(
            context,
            WordsDatabase::class.java,
            "word_database"
        ).build()
    }

    @Provides
    fun provideWordDAO(wordsDatabase: WordsDatabase): WordDAO {
        return wordsDatabase.wordDAO()
    }
}