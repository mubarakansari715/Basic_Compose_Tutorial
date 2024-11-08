package com.mubarak.basic_compose_tutorial.assignment.assignmentone

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.model.ItemModel


object DataManager {

    @JvmField
    var dataList = emptyArray<ItemModel>()

    private var isDataLoaded = mutableStateOf(false)

    var currentListItem = ItemModel()

    var isRedirection = mutableStateOf(REDIRECTION.LISTING)

    fun loadJSONFromAsset(context: Context) {
        val json = context.assets.open("quotes.json").use { inputStream ->
            inputStream.readBytes().toString(Charsets.UTF_8)
        }
        dataList = Gson().fromJson(json, Array<ItemModel>::class.java).toList().toTypedArray()
        isDataLoaded.value = true
    }

    fun getDataList() = dataList

    fun isDataLoaded() = isDataLoaded.value

    fun redirectScreen() {
        if (isRedirection.value == REDIRECTION.LISTING) {
            isRedirection.value = REDIRECTION.DETAILS
        } else {
            isRedirection.value = REDIRECTION.LISTING
        }
    }
}

enum class REDIRECTION {
    LISTING,
    DETAILS
}