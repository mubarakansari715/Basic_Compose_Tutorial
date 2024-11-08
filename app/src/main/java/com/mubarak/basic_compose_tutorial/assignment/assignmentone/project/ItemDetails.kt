package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.DataManager
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.model.ItemModel

@Composable
fun ItemDetails(item: ItemModel, modifier: Modifier) {
    BackHandler {
        DataManager.redirectScreen() // Handle system back button
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.sweepGradient(
                    listOf(
                        Color(0xFFFFFFFF), Color(0xFFE3E3E3)
                    )
                )
            )
    ) {
        // Row for the back button at the top
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .size(30.dp)
                    .clickable { DataManager.redirectScreen() } // Handle back button click
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Details",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp
            )
        }

        // Main card content centered in the screen
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                elevation = CardDefaults.cardElevation(8.dp),
            ) {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp, vertical = 40.dp)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        Modifier.size(80.dp)
                    )
                    Text(
                        item.text,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Box(
                        modifier = Modifier
                            .alpha(0.1f)
                            .background(Color.DarkGray)
                            .height(1.dp)
                            .fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        item.author,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(horizontal = 10.dp)
                    )
                }
            }
        }
    }
}