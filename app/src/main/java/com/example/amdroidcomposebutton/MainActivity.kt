package com.example.amdroidcomposebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.io.Serializable

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainFun()
        }
    }
}

class Args(
    val color: Color,
    val borderWidth: Dp,
    val borderColor: Color,
) : Serializable

val colors = arrayListOf(
    Color.Blue,
    Color.White,
    Color.Black,
    Color.DarkGray,
    Color.LightGray,
    Color.Green,
    Color.Yellow,
    Color.Red,
    Color.Cyan,
    Color.Magenta,
    Color.Transparent,
    Color.Unspecified
)
val borders = arrayListOf(
    1, 2, 3, 4, 5
)

fun randArgs() = Args(colors.random(), borders.random().dp, colors.random())

@Composable
fun MainFun() {
    val btn1 = rememberSaveable { mutableStateOf(randArgs()) }
    val btn2 = rememberSaveable { mutableStateOf(randArgs()) }
    val btn3 = rememberSaveable { mutableStateOf(randArgs()) }
    Column (
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(20.dp)
            .fillMaxSize()

    ) {
        Button(
            onClick = {
                btn2.value = randArgs()
                btn3.value = randArgs()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = btn1.value.color
            ),
            border = BorderStroke(btn1.value.borderWidth, btn1.value.borderColor)
        ) { Text("BTN 1", fontSize = 28.sp) }

        Button(
            onClick = {
                btn1.value = randArgs()
                btn3.value = randArgs()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = btn2.value.color
            ),
            border = BorderStroke(btn2.value.borderWidth, btn2.value.borderColor)
        ) { Text("BTN 2", fontSize = 28.sp) }
        Button(
            onClick = {
                btn2.value = randArgs()
                btn1.value = randArgs()
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = btn3.value.color
            ),
            border = BorderStroke(btn3.value.borderWidth, btn3.value.borderColor)
        ) { Text("BTN 3", fontSize = 28.sp) }
    }
}
