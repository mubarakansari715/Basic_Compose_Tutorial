package com.mubarak.basic_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.DataManager
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.REDIRECTION
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.AssignmentOneMain
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.ItemDetails
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.project.ItemListingScreen
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadJSONFromAsset(applicationContext)
        }

        setContent {
            Basic_Compose_TutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val screenModifier = Modifier.padding(innerPadding)
                    //DummyListLayout(screenModifier)
                    //TextViewBasics(screenModifier)
                    //EditTextComponent(screenModifier)
                    //ModifierComponent(screenModifier)
                    //LazyColumnsComponent(screenModifier)
                    //StateManagementComponent(screenModifier)
                    AssignmentOneMain(screenModifier)
                }
            }
        }
    }
}