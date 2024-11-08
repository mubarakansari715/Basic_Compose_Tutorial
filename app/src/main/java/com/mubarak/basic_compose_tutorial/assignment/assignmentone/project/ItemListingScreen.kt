package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.model.ItemModel

@Composable
fun ItemListingScreen(
    modifier: Modifier,
    dataList: Array<ItemModel>,
    itemClicked: (ItemModel) -> Unit
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Demo app",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Medium,
            fontSize = 18.sp
        )
        ItemListing(dataList, itemClicked)
    }
}