package com.mubarak.basic_compose_tutorial.basics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.R
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme

//Dummy List
@Composable
fun DummyListLayout(modifier: Modifier = Modifier) {
    /***
     * Create all data views at once. For example, if you have 1,000 data items,
     * all 1,000 items will be displayed immediately. This is a disadvantage of
     * using verticalScroll(rememberScrollState()). A better approach is to use
     * LazyColumn, which loads data lazily, meaning only the views currently visible
     * on the screen are created.
     */
    Column(modifier = modifier.padding(8.dp).verticalScroll(rememberScrollState())) {
        dummyListItem()
        dummyListItem()
        dummyListItem()
        dummyListItem()
    }
}

@Composable
fun dummyListItem() {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.DarkGray)
    ) {
        Image(
            painter = painterResource(R.drawable.ic_launcher_background),
            contentDescription = ""
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(text = "Mubarak", fontWeight = FontWeight.Bold, color = Color.White)
            Text(text = "Software Developer", fontWeight = FontWeight.Thin, color = Color.White)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun Dummy_Preview() {
    Basic_Compose_TutorialTheme {
        DummyListLayout()
    }
}