package com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(onClick: (String) -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick("Mubarak ho!") },
        contentAlignment = Alignment.Center
    ) {
        Text("Login screen", modifier = Modifier.align(Alignment.Center), fontSize = 30.sp)
    }
}

@Composable
fun RegisterScreen(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text("Register screen", modifier = Modifier.align(Alignment.Center), fontSize = 30.sp)
    }
}

@Composable
fun MainScreen(name: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Column {
            Text("Main screen", fontSize = 30.sp)
            Text("Welcome to $name", fontSize = 24.sp)
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun previewLoginScreen() {
    MainScreen("Jon", onClick = {})
}