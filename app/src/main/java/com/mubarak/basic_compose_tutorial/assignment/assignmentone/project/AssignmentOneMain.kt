package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.DataManager
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.REDIRECTION

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
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(
                "Loading...",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 24.sp
            )
        }
    }
}