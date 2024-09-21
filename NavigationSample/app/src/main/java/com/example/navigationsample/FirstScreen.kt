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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FirstScreen(navigationToSecondScreen:(String,Int)->Unit){
    val name = remember{ mutableStateOf("") }
    val age = remember{ mutableIntStateOf(0) }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(text = "This is the First Screen", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = name.value, onValueChange = {
            name.value = it
        })
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = age.intValue.toString(), onValueChange = {
            age.intValue = it.toIntOrNull()?:0
        })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigationToSecondScreen(name.value,age.intValue)
        }) {
            Text(text = "Go to Second Screen")
            Spacer(modifier = Modifier.width(16.dp))
            Icon(Icons.Default.PlayArrow, contentDescription = "")
        }
    }
}
//toUIntOrNull()?:1u

@Preview(showBackground = true)
@Composable
fun FirstPreview(){
//    FirstScreen( )
}