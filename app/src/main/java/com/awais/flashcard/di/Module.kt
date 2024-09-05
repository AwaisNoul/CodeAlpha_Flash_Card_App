package com.awais.flashcard.di

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import androidx.room.Room
import com.awais.flashcard.data.room.FlashCardDao
import com.awais.flashcard.data.room.FlashCardDatabase
import com.awais.flashcard.ui.viewmodels.FlashCardViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {


    @Singleton
    @Provides
    fun provideFlashCardDataBase(@ApplicationContext context: Context): FlashCardDatabase {
        return Room.databaseBuilder(
            context,
            FlashCardDatabase::class.java,
            "flashcard_database"
        ).build()
    }

    @Singleton
    @Provides
    fun provideFlashCardDao(database: FlashCardDatabase): FlashCardDao {
        return database.flashCardDao()
    }

    @Provides
    @Singleton
    fun provideFlashCardViewModel(flashCardDatabase: FlashCardDatabase): FlashCardViewModel {
        return FlashCardViewModel(flashCardDatabase)
    }
}

