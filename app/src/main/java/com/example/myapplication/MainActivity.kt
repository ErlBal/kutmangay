
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
import androidx.compose.ui.graphics.Color
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
    var cLow by remember { mutableIntStateOf(0) }
    var cMid by remember { mutableIntStateOf(0) }
    var cHigh by remember { mutableIntStateOf(0) }
    var last by remember { mutableStateOf("") }

    Column(modifier = modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
            Button(onClick = { cLow++; last = "low" }, colors = ButtonDefaults.buttonColors(Color.Red)) { Text("Start")}
            Button(onClick = { cMid+=5; last = "mid" }, colors = ButtonDefaults.buttonColors(Color.Blue)) { Text("Mid") }
            Button(onClick = { cHigh+=10; last = "high" }, colors = ButtonDefaults.buttonColors(Color.Gray)) { Text("End") }
        }

        Row(Modifier.fillMaxWidth(), Arrangement.SpaceEvenly) {
            Text("$cLow")
            Text("$cMid")
            Text("$cHigh")
        }

        Spacer(Modifier.height(20.dp))

        Text(text = "Current button: \n$last", style = MaterialTheme.typography.headlineLarge)
    }
}