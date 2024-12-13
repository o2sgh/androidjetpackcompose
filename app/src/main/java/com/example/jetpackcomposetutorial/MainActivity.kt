package com.example.jetpackcomposetutorial


import android.content.Context
import android.content.Intent
import android.content.res.loader.ResourcesProvider
import android.os.Bundle
import android.widget.Toast
import android.window.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults

import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            splashScreen()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun preview(){
    /*Column {
        testText("Haider")
        testImage()
        testButton()

        Row {
            testText("Haider")
            testText("Ali")
        }

        testTextField()
    }*/



    splashScreen()

    //testBoxLayout()

}

@Composable
fun testText (name : String =  "CheezyCode"){
    Text(
        text = "Hello ${name}",
        color = Color.Red,
        fontSize = 30.sp,
        fontStyle = FontStyle.Italic
    )
}

@Composable
fun testImage(){
    Image(
        painter = painterResource(id = R.drawable.heart),
        contentDescription = "test contentDescription",
        )
}




@Composable
fun splashScreen(){
    val context: Context = LocalContext.current
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            val i = Intent(context, RegisterActivity::class.java)
            context.startActivity(i);
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                ),
        ) {
            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
                modifier = Modifier
            )
        }
    }
}