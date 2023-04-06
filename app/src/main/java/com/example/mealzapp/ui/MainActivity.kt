package com.example.mealzapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mealzapp.ui.details.MealsDetailScreen
import com.example.mealzapp.ui.details.MealsDetailViewModel

import com.example.mealzapp.ui.meals.MealsCategoriesScreen

import com.example.mealzapp.ui.theme.MealzAppTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                FoodiezApp()

            }
        }
    }
}

@Composable
private fun FoodiezApp()
{
    val navController= rememberNavController( )
    NavHost(navController = navController, startDestination = "destination-meals-list" ) {
        composable(route = "destination-meals-list") {
            MealsCategoriesScreen { navigationMealId -> navController.navigate("destination-meals-details/$navigationMealId") }
        }
        composable(
            route = "destination-meals-details/{meal_category_id}",
            arguments = listOf(navArgument("meal_category_id") {
                type = NavType.StringType

            }))
        {
            val viewModel:MealsDetailViewModel= viewModel()
           MealsDetailScreen(meal =viewModel.mealState.value )
        }
    }
}