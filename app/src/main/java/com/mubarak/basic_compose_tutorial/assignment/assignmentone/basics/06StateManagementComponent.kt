package com.mubarak.basic_compose_tutorial.assignment.assignmentone.basics

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme

/***
 * State management
 * remember -> Just remember the last data
 * rememberSaveable -> remember the data even screen is rotate
 * Imp point :
 *          1) Data : Always date go with Top-Down(like any changes in view)
 *          2) Event : Always go Bottom-Top(like clicked events)
 */

@Composable
fun StateManagementComponent(modifier: Modifier = Modifier) {
    val notificationCount = rememberSaveable { mutableStateOf(0) }

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NotificationComponentDesign(notificationCount.value) { notificationCount.value++ }
        NotificationDesign(notificationCount.value)
    }

}

@Composable
fun NotificationDesign(count: Int) {
    Card(
        modifier = Modifier,
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(modifier = Modifier.padding(20.dp)) {
            Text("Notification received count is => $count")
        }
    }
}

@Composable
private fun NotificationComponentDesign(count: Int, countIncrease: () -> Int) {
    Column(verticalArrangement = Arrangement.Center) {
        Text(
            text = "Notification Count => ${count}"
        )
        Button(onClick = {
            countIncrease()
        }) {
            Text("Send Notification")
        }
    }
}


@Composable
@Preview(showSystemUi = true)
fun StateManagementComponent_Preview() {
    Basic_Compose_TutorialTheme {
        StateManagementComponent()
    }
}