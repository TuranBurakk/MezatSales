package com.example.mezatsales.presentation.customView

import android.text.Html
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.mezatsales.R
import com.example.mezatsales.data.ItemData
import com.example.mezatsales.presentation.Screen


@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun ExpandableCard(
    navController: NavController,
    address : String,
    lastPrice: String,
    title: String,
    category:String,
    image: String,
    titleFontSize: TextUnit = MaterialTheme.typography.headlineMedium.fontSize,
    titleFontWeight: FontWeight = FontWeight.Bold,
    description: String,
    descriptionFontSize: TextUnit = MaterialTheme.typography.titleMedium.fontSize,
    descriptionFontWeight: FontWeight = FontWeight.Normal,
    descriptionMaxLines: Int = 4,
    shape: Shape = ShapeDefaults.Medium
) {

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
    )

    Card(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )

            ,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.secondary
        )
        ,
        shape = shape,
        onClick = {

            val item = ItemData(address,lastPrice,category,title,description,image)
            navController.currentBackStackEntry?.savedStateHandle?.set(
                key = "item",
                value = item
            )
            navController.navigate(Screen.ItemDetailScreen.route)


        }
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

                GlideImage(model = image,
                        contentDescription ="image",
                    modifier = Modifier.fillMaxWidth().padding(top = 10.dp))

            Text(
                modifier = Modifier.align(CenterHorizontally).padding(top = 4.dp),
                text = title,
                fontSize = titleFontSize,
                fontWeight = titleFontWeight,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(text = getBoldText(text = R.string.Price, text2 = lastPrice ),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.align(CenterHorizontally).padding(top = 4.dp))
            Text(text = getBoldText(text = R.string.Address, text2 = address),
                        color = MaterialTheme.colorScheme.onSurface,
                        modifier = Modifier.align(CenterHorizontally).padding(top = 4.dp))


                Row(Modifier.padding(start = 5.dp)
                    , horizontalArrangement = Arrangement.End) {

                    IconButton(
                        modifier = Modifier
                            .rotate(rotationState)
                            .align(CenterVertically)
                            .wrapContentWidth(Alignment.End)

                            ,
                        onClick = {
                            expandedState = !expandedState
                        }) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Drop-Down Arrow"
                        )
                    }
                }


            if (expandedState) {

                Text(
                    text = description,
                    fontSize = descriptionFontSize,
                    fontWeight = descriptionFontWeight,
                    maxLines = descriptionMaxLines,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.align(CenterHorizontally),
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        }
    }
}

@Composable
fun getBoldText(text:Int,text2:String):String{
    val bold = stringResource(id = text)
    return "${ Html.fromHtml(bold)} $text2"
}



