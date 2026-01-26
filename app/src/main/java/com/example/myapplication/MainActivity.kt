package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    private val TAG = "Lifecycle"
    private val lifecycleLogs = mutableStateListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addLog("onCreate")
        setContent {
            MyApplicationTheme {
                BusinessCardApp(logs = lifecycleLogs)
            }
        }
    }

    override fun onStart() {
        super.onStart()
        addLog("onStart")
    }

    override fun onResume() {
        super.onResume()
        addLog("onResume")
    }

    private fun addLog(method: String) {
        Log.d(TAG, "$method called")
        lifecycleLogs.add(method)
    }
}

@Composable
fun BusinessCardApp(logs: List<String>) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFD2E8D4)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(1.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.android_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color(0xFF073042))
                        .padding(8.dp)
                )
                Text(
                    text = stringResource(R.string.full_name),
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Light,
                    modifier = Modifier.padding(top = 8.dp)
                )
                Text(
                    text = stringResource(R.string.title),
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF006D3B),
                    modifier = Modifier.padding(top = 4.dp)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(vertical = 16.dp)
            ) {
                logs.forEach { log ->
                    Text(
                        text = log,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }

            val contactInfo = listOf(
                ContactDetails(Icons.Default.Phone, stringResource(R.string.phone_number)),
                ContactDetails(Icons.Default.Share, stringResource(R.string.social_media)),
                ContactDetails(Icons.Default.Email, stringResource(R.string.email_address))
            )

            LazyColumn(
                modifier = Modifier
                    .padding(bottom = 32.dp)
                    .width(250.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(contactInfo) { contact ->
                    ContactRow(icon = contact.icon, text = contact.text)
                }
            }
        }
    }
}

data class ContactDetails(val icon: ImageVector, val text: String)

@Composable
fun ContactRow(icon: ImageVector, text: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF006D3B),
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color.Black
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    MyApplicationTheme {
        BusinessCardApp(logs = listOf("onCreate", "onStart", "onResume"))
    }
}
