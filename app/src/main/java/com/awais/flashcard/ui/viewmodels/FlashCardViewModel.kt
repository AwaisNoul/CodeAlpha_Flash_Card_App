package com.awais.flashcard.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.awais.flashcard.data.room.FlashCardDatabase
import com.awais.flashcard.models.FlashCardEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FlashCardViewModel @Inject constructor(flashCardDatabase: FlashCardDatabase) :ViewModel() {

    private val flashCardDao = flashCardDatabase.flashCardDao()
    val flashCards = MutableStateFlow<List<FlashCardEntity>>(listOf())

    fun addFlashCard(question: String, answer: String) {
        viewModelScope.launch {
            val flashCard = FlashCardEntity(question = question, answer = answer)
            flashCardDao.insertFlashCard(flashCard)
        }
    }

    fun deleteFlashCard(flashCard: FlashCardEntity) {
        viewModelScope.launch {
            flashCardDao.deleteFlashCard(flashCard)
        }
    }


    fun getAllFlashCards(){
        viewModelScope.launch {
            val list=flashCardDao.getAllFlashCards()
            flashCards.value = list
        }
    }

    fun deleteAllFlashCards(){
        viewModelScope.launch {
            flashCardDao.deleteAllFlashCards()
        }
    }

}
