package com.example.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.mealzapp.model.response.MealsResponse

@Composable
fun MealsDetailScreen(meal :MealsResponse?)
{  var profilepicturestate by remember { mutableStateOf(MealProfileStructureState.Normal) }
    val transition= updateTransition(targetState = profilepicturestate,label="")
    val imagesizeDp by transition.animateDp(targetValueByState = { it.size}, label = "" )
    val color by transition.animateColor(targetValueByState = { it.color}, label = "" )
    val widthsize by transition.animateDp(targetValueByState = { it.borderwidth}, label = "" )

    Column {
        Row {
            Card(modifier = Modifier.padding(16.dp),
               shape = CircleShape, border = BorderStroke(width = widthsize,color= color)
            ) {
                val painter = rememberImagePainter(data =meal?.imageurl, builder = {transformations(CircleCropTransformation())})
                Image(
                    painter = painter,
                    contentDescription = null,
                    modifier = Modifier
                        .size(imagesizeDp)
                        .padding(8.dp)
                    )
            }
            Text(text = meal?.name?:"default name", modifier = Modifier.padding(16.dp).align(Alignment.CenterVertically), style = MaterialTheme.typography.h6, fontWeight = FontWeight.SemiBold)
        }
        Text(text = meal?.description?:"default name", modifier = Modifier.padding(16.dp).align(Alignment.CenterHorizontally))
//        Button(modifier = Modifier.padding(16.dp), onClick = { profilepicturestate=if(profilepicturestate==MealProfileStructureState.Normal)
//             MealProfileStructureState.Expanded
//             else
//             MealProfileStructureState.Normal}) {
//             Text(text = "Change state of meal profile picture ")
//
//        }
    }

}

enum class MealProfileStructureState(val color: Color, val size: Dp, val borderwidth:Dp){
    Normal(Color.White,120.dp,8.dp),
    Expanded(Color.Green,200.dp,24.dp);
}