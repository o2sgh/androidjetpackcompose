package com.example.jetpackcomposetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import com.example.jetpackcomposetutorial.ui.LoginActivity

class RegisterActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //LoginScreen()
            PreviewLoginScreen()
            }
        }
}

@Composable
fun LoginScreen() {
    val context = LocalContext.current

    // State variables for user input
    var username by remember { mutableStateOf("") }
    var loginErrorMessage by remember { mutableStateOf("") }

    // Handle login button click (simple validation)
    fun onRegisterClick() {
        if (username.isEmpty()) {
            loginErrorMessage = "Please enter registration code"
        } else {
            // Simulate login success or failure
             if (username == "123") {
                 //loginErrorMessage = "Device Registeration Successful!"
                 val i = Intent(context,LoginActivity::class.java)
                 context.startActivity(i)
            } else {
                 loginErrorMessage = "Invalid registration code"
            }
        }
    }

    // Column to align elements vertically
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Title
        Text(text = "Register", style = MaterialTheme.typography.headlineMedium)
        Text(text = "Dojo Pocket Fetch", style = MaterialTheme.typography.bodyMedium)

        Spacer(modifier = Modifier.height(32.dp))

        // Username TextField
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            //label = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Spacer(modifier = Modifier.height(16.dp))

        // Error message if login fails
        if (loginErrorMessage.isNotEmpty()) {

            Text(
                text = loginErrorMessage,
                color = Color.Red,
                style = MaterialTheme.typography.bodyMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Login Button
        Button(
            onClick = { onRegisterClick() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White),
                        enabled = username.isNotEmpty()
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register link (optional)
        TextButton(onClick = { /* Handle registration screen navigation */ }) {
            Text("Don't have a Registration code? Click here")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .height(180.dp)
                .fillMaxWidth()
                .background(Color(0xC48E17))
        ){
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(bottom = 20.dp)
            )
            Image(painter = painterResource(id = R.drawable.red_shape), contentDescription = "",
                modifier = Modifier
                    .height(104.dp)
                    .width(60.dp)
            )

            Box (
                modifier = Modifier.align(Alignment.TopEnd)
                    .padding(end = 30.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.yellow_shape),
                    contentDescription = "",
                    modifier = Modifier
                        .height(65.dp)
                        .width(136.dp)
                )
            }

            Box (
                modifier = Modifier.align(Alignment.BottomEnd)
                    .offset(30.dp,50.dp)
            ){
                Image(
                    painter = painterResource(id = R.drawable.roundblue_shape),
                    contentDescription = "",
                    modifier = Modifier
                        .height(130.dp)
                        .width(130.dp)
                )
            }


        }

        Box(
            modifier = Modifier
                .height(700.dp)
                .align(Alignment.BottomCenter)
                .clip(RoundedCornerShape(topStartPercent = 10, topEndPercent = 10))
                .background(Color.White) // Background color for the container
        ){
            LoginScreen()
        }
    }



}