package com.example.mealzapp.ui.meals

import android.util.Log
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mealzapp.model.MealsRepository

import com.example.mealzapp.model.response.MealsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class MealsCategoriesViewModel(private val repository: MealsRepository= MealsRepository.getInstance()):ViewModel() {
    init {
      Log.d("TAG_COROUTINES","we are about to launch a coroutine")//1
       viewModelScope.launch(Dispatchers.IO) {
           Log.d("TAG_COROUTINES","we have  launch a coroutine")//3
                val meals=getMeals()
           Log.d("TAG_COROUTINES","we are received the async data")//4
            mealsstate.value=meals
            }
        Log.d("TAG_COROUTINES","other work")//2
        }

    val mealsstate: MutableState<List<MealsResponse>> = mutableStateOf(emptyList<MealsResponse>())




  private  suspend fun getMeals():List<MealsResponse>{
         return  repository.getMeals().categories

    }

}