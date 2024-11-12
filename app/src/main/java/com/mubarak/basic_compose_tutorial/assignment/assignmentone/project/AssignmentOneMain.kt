package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.DataManager
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.REDIRECTION
import kotlinx.coroutines.delay

@Composable
fun AssignmentOneMain(modifier: Modifier) {

    if (DataManager.isDataLoaded()) {
        if (DataManager.isRedirection.value == REDIRECTION.LISTING) {
            ItemListingScreen(
                modifier = modifier, dataList = DataManager.getDataList()
            ) { item ->
                DataManager.currentListItem = item
                DataManager.redirectScreen()
            }
        } else {
            ItemDetails(DataManager.currentListItem, modifier)
        }

    } else {
        LoaderShow()
    }
}

@Composable
fun LoaderShow() {

    val degree = produceState(initialValue = 0) {
        while (true) {
            delay(16)
            value = (value + 8) % 360
        }
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

        Column {
            Image(
                imageVector = Icons.Default.Refresh,
                contentDescription = "",
                modifier = Modifier
                    .size(60.dp)
                    .rotate(degree.value.toFloat())
            )
            Text(
                "Loading...",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp
            )
        }
    }
}