package com.example.mealzapp.model.response

import com.google.gson.annotations.SerializedName


data class MealsCategoriesResponse(val categories:List<MealsResponse>)

data class MealsResponse (@SerializedName("idCategory")  val  id:String,
                          @SerializedName("strCategory")  val  name :String,
                          @SerializedName("strCategoryThumb")  val  imageurl: String,
                          @SerializedName("strCategoryDescription")  val  description:String)



