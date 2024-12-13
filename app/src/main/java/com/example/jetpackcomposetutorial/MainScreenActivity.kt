package com.example.jetpackcomposetutorial

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposetutorial.ui.theme.JetPackComposeTutorialTheme

import kotlin.random.Random

class MainScreenActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainScreen(){
    val items = List(100) { "Outlet $it" } // Sample data

    val context = LocalContext.current
    Column {

        Box (
            modifier = Modifier
                .height(70.dp)
                .fillMaxWidth()
                .background(Color.LightGray),

        ){
            Text(
                modifier = Modifier.align(Alignment.Center)
                    .padding(0.dp,20.dp,0.dp,0.dp),
                text = "Select Outlets")

            IconButton(
                modifier = Modifier.align(Alignment.CenterEnd)
                    .padding(0.dp,20.dp,0.dp,0.dp),
                onClick = { /* Handle click */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Menu,  // Choose a built-in icon
                    contentDescription = "Home Icon",
                    tint = Color.Black, // Change icon color
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(items) { item ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {
                                val i = Intent(context,OutletDetailActivity::class.java)
                                context.startActivity(i)
                            })
                            .border(1.dp, Color.LightGray, RoundedCornerShape(16.dp))
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(horizontal = 10.dp)
                        ) {
                            Box(modifier = Modifier.height(24.dp).width(24.dp).background(
                                getRandomColor(), RoundedCornerShape(100.dp)).border(1.dp, Color.LightGray, RoundedCornerShape(100.dp)))
                            Text(
                                text = item,
                                modifier = Modifier
                                    .padding(16.dp)
                            )

                        }


                    }
                }
            }
        }
    }
}


fun getRandomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat(),
        alpha = 1f // Full opacity
    )
}

