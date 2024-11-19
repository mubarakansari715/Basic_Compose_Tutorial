package com.mubarak.basic_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.unit.dp
import com.mubarak.basic_compose_tutorial.assignment.assignmentone.DataManager
import com.mubarak.basic_compose_tutorial.assignment.assignmenttwo.main.AppNavigation
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
                    //Assignment one
                    //DummyListLayout(screenModifier)
                    //TextViewBasics(screenModifier)
                    //EditTextComponent(screenModifier)
                    //ModifierComponent(screenModifier)
                    //LazyColumnsComponent(screenModifier)
                    //StateManagementComponent(screenModifier)
                    //AssignmentOneMain(screenModifier)

                    //Assignment two
                    //LoaderShow()
                    AppNavigation()
                }
            }
        }
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
            Text("Loading...")
        }
    }
}