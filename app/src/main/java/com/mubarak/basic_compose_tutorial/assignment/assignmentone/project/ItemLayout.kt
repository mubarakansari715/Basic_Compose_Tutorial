package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.model.ItemModel


@Composable
fun ItemLayout(item: ItemModel, itemClicked: (ItemModel) -> Unit) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .clickable { itemClicked(item) },
        elevation = CardDefaults.cardElevation(4.dp),
    ) {
        Row(modifier = Modifier.padding(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                imageVector = Icons.Filled.Info,
                contentDescription = "",
                Modifier.size(50.dp)
            )
            Column(modifier = Modifier.padding(start = 10.dp)) {
                Text(item.text, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .alpha(0.1f)
                        .background(Color.DarkGray)
                        .fillMaxWidth()
                        .height(1.dp)
                )
                Text(
                    text = item.author ?: "Unknown Author",
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}