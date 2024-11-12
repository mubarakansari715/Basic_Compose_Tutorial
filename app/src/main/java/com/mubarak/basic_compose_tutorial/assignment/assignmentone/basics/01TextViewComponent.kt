package com.mubarak.basic_compose_tutorial.assignment.assignmentone.basics

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme

@Composable
fun TextViewBasics(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier
            .padding(20.dp)
            .background(Color.Yellow),
        text = "Hello TextView Component",
        fontSize = 28.sp,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        color = Color.Green
    )
}

@Composable
@Preview(showSystemUi = true)
private fun TextViewBasics_Preview() {
    Basic_Compose_TutorialTheme {
        TextViewBasics()
    }
}