package com.mubarak.basic_compose_tutorial.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.R

/***
 * Modifies=>
 * Main impotent terms:
 *  1) Sequence of modifiers
 *  2) set modifies as a parameter
 *  3) make sre add clickable modified put correct sequence
 */
@Composable
fun ModifierComponent(modifier: Modifier = Modifier) {
//    Text(
//        text = "Mubarak Ansari",
//        modifier = Modifier
//            .background(Color.Blue)
//            .border(2.dp, color = Color.Yellow)
//            .padding(40.dp)
//            .border(2.dp, color = Color.Red)
//            .padding(10.dp)
//
//    )

    //crop image in easy way
    Image(
        painter = painterResource(R.drawable.ic_launcher_background),
        contentDescription = "",
        contentScale = ContentScale.Crop,
        modifier = modifier
            .size(200.dp)
            .padding(20.dp)
            .clip(CircleShape)
            .border(2.dp, Color.DarkGray, CircleShape)
            .clickable {  }
    )
}

@Composable
@Preview(showSystemUi = true)
private fun ModifierComponent_Preview() {
    ModifierComponent()
}