package com.mubarak.basic_compose_tutorial.assignment.assignmentone.basics

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme

@Composable
fun EditTextComponent(modifier: Modifier = Modifier) {
    val stateUserEmail = remember { mutableStateOf("") }
    TextField(
        modifier = modifier.padding(horizontal = 10.dp, vertical = 20.dp).fillMaxWidth(),
        value = stateUserEmail.value,
        onValueChange = {
            stateUserEmail.value = it
        },
        label = {Text(text = "Enter email")},
        singleLine = true,
    )
}

@Composable
@Preview(showSystemUi = true)
private fun EditTextComponent_Preview() {
    Basic_Compose_TutorialTheme {
        EditTextComponent()
    }
}