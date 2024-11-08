package com.mubarak.basic_compose_tutorial.assignment.assignmentone.project

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.model.ItemModel

@Composable
fun ItemListing(dataList: Array<ItemModel>, itemClicked: (ItemModel) -> Unit) {
    LazyColumn(content = {
        items(dataList) { item ->
            ItemLayout(item, itemClicked)
        }
    })
}