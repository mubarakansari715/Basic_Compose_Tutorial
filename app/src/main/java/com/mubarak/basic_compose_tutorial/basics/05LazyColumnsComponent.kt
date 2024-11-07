package com.mubarak.basic_compose_tutorial.basics

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.R


@Composable
fun LazyColumnsComponent(modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier, content = {
        items(getUserProfileData()) { item ->
            ListItems(username = item.username, occupation = item.occupation)
        }
    })
}

@Composable
fun ListItems(username: String, occupation: String) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(),
        onClick = {
            Toast.makeText(context, "Clicked on Full Item", Toast.LENGTH_SHORT).show()
        }
    ) {
        Row(modifier = Modifier.padding(15.dp)) {
            Image(
                painter = painterResource(R.drawable.ic_launcher_background),
                contentDescription = "",
                Modifier
                    .size(60.dp)
                    .clickable {
                        Toast.makeText(context, "Clicked on Profile", Toast.LENGTH_SHORT)
                            .show()
                    },
            )
            ItemDescriptions(
                username = username,
                occupation = occupation,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Composable
private fun ItemDescriptions(username: String, occupation: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = username,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.headlineSmall
        )
        Text(
            text = occupation,
            textAlign = TextAlign.Start,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
@Preview(showSystemUi = true)
private fun LazyColumnsComponent_Preview() {
    LazyColumnsComponent()
}

fun getUserProfileData(): MutableList<UserModel> {
    return mutableListOf(
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
        UserModel(username = "Mubarak Ansari", occupation = "Software Developer"),
    )
}

data class UserModel(
    val username: String,
    val occupation: String
)