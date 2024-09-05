package com.awais.flashcard.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.awais.flashcard.models.FlashCardEntity


@Database(entities = [FlashCardEntity::class], version = 1,exportSchema = false)
abstract class FlashCardDatabase : RoomDatabase() {
    abstract fun flashCardDao(): FlashCardDao
}
