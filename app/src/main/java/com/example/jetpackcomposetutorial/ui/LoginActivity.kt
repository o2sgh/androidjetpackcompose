package com.example.jetpackcomposetutorial.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.MainScreen
import com.example.jetpackcomposetutorial.MainScreenActivity
import com.example.jetpackcomposetutorial.ui.ui.theme.JetPackComposeTutorialTheme

import com.example.jetpackcomposetutorial.R


class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetPackComposeTutorialTheme {
               PreviewLoginScreen()
            }
        }
    }
}


@Composable
fun LoginScreen() {
    val context = LocalContext.current
    // State variables for user input
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    var loginErrorMessage by remember { mutableStateOf("") }

    // Handle login button click (simple validation)
    fun onLoginClick() {
        if (username.isEmpty() || password.isEmpty()) {
            loginErrorMessage = "Please enter both username and password"
        } else {
            // Simulate login success or failure
            if (username == "user" && password == "password") {
                loginErrorMessage = "Login Successful!"
                val i = Intent(context, MainScreenActivity::class.java)
                context.startActivity(i)
            } else {
                loginErrorMessage = "Invalid username or password"
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
        Text(text = "Login", style = MaterialTheme.typography.headlineMedium)
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


        // Password TextField with visibility toggle
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            //label = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            trailingIcon = {
                IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Toggle password visibility"
                    )
                }
            }
        )




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
            onClick = { onLoginClick() },
            modifier = Modifier.fillMaxWidth(),
            enabled = username.isNotEmpty() && password.isNotEmpty()
        ) {
            Text("Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Register link (optional)
        TextButton(onClick = { /* Handle registration screen navigation */ }) {
            Text("Don't have an account? Sign up")
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
                modifier = Modifier
                    .align(Alignment.TopEnd)
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
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .offset(30.dp, 50.dp)
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