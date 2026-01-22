
package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var c1 by remember { mutableIntStateOf(0) }
    var c2 by remember { mutableIntStateOf(0) }
    var c3 by remember { mutableIntStateOf(0) }
    var last by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
            Button(onClick = { c1++; last = "low" }) { Text("Start") }
            Button(onClick = { c2+=5; last = "mid" }) { Text("Mid") }
            Button(onClick = { c3+=10; last = "high" }) { Text("End") }
        }

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
            Text("$c1")
            Text("$c2")
            Text("$c3")
        }

        Spacer(Modifier.height(20.dp))

        Text(text = last, style = MaterialTheme.typography.headlineLarge)
    }
}