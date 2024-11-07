package com.mubarak.basic_compose_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mubarak.basic_compose_tutorial.basics.LazyColumnsComponent
import com.mubarak.basic_compose_tutorial.basics.ModifierComponent
import com.mubarak.basic_compose_tutorial.ui.theme.Basic_Compose_TutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Basic_Compose_TutorialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //DummyListLayout(modifier = Modifier.padding(innerPadding))
                    //TextViewBasics(modifier = Modifier.padding(innerPadding))
                    //EditTextComponent(modifier = Modifier.padding(innerPadding))
                    //ModifierComponent(modifier = Modifier.padding(innerPadding))
                    LazyColumnsComponent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}