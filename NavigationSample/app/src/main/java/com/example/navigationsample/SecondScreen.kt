package com.example.navigationsample

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SecondScreen(name :String,age :Int,navigateToFirstScreen:()->Unit){

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the Second Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Welcome !! $name", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigateToFirstScreen()
        }) {
            Text(text = "Go to First Screen")
            Spacer(modifier = Modifier.width(16.dp))
            Icon(Icons.Default.PlayArrow, contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SecondPreview(){
    SecondScreen("Arya",0,{})
}