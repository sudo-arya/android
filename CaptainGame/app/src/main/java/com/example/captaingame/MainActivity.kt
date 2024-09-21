package com.example.captaingame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){
    val treasureFound = remember{ mutableIntStateOf(0) }
    val direction = remember { mutableStateOf("North") }
    val healthBar = remember {mutableIntStateOf(100)}
    val stormOrTreasure = remember {
        mutableStateOf("")
    }

    Column (
        modifier = Modifier.fillMaxSize(),
//        color = MaterialTheme.colorScheme.background
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

    ){
        Row {
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Treasure Amount : ", textAlign = TextAlign.Center)
                Text(text = "${treasureFound.intValue}", textAlign = TextAlign.Center)
            }
            Spacer(modifier = Modifier.width(32.dp))
            Column (
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Text(text = "Heading Towards : \n${direction.value}", textAlign = TextAlign.Center)
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Text(text = "Health Left : \n")
            Row {
                Text(text = "${healthBar.intValue}/100")
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            if(healthBar.intValue == 0){
                Text(text = "You are DEAD :(", color = Color.Red, textAlign = TextAlign
                    .Center)
            } else if (stormOrTreasure.value == "!! Found Treasure !!"){
                Text(text = stormOrTreasure.value, color = Color.Green, textAlign = TextAlign.Center)
                Icon(Icons.Default.CheckCircle, contentDescription = "", /*Color = Color.Green*/)
            }else if (stormOrTreasure.value == "Encountered Storm "){
                Text(text = stormOrTreasure.value, color = Color.Gray, textAlign = TextAlign.Center)
                Icon(Icons.Default.Build, contentDescription = "", /*Color = Color.Gray*/)
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = {
                if (healthBar.intValue >0) {
                    direction.value = "North"
                    if (Random.nextBoolean()) {
                        treasureFound.intValue += 1
                        stormOrTreasure.value = "!! Found Treasure !!"
                    } else {
                        healthBar.intValue -= 5
                        stormOrTreasure.value = "Encountered Storm "
                    }
                }
            }) {
                Text(text = "Sail North")
            }
            Spacer(modifier = Modifier.width(38.dp))
            Row {
                Button(onClick = {
                    if (healthBar.intValue >0) {
                        direction.value = "South"
                        if (Random.nextBoolean()) {
                            treasureFound.intValue += 1
                            stormOrTreasure.value = "!! Found Treasure !!"
                        } else {
                            healthBar.intValue -= 5
                            stormOrTreasure.value = "Encountered Storm "
                        }
                    }
                }) {
                    Text(text = "Sail South")
                }
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            Button(onClick = {
                if (healthBar.intValue >0) {
                    direction.value = "East"
                    if (Random.nextBoolean()) {
                        treasureFound.intValue += 1
                        stormOrTreasure.value = "!! Found Treasure !!"
                    } else {
                        healthBar.intValue -= 5
                        stormOrTreasure.value = "Encountered Storm "
                    }
                }
            }) {
                Text(text = "Sail East")
            }
            Spacer(modifier = Modifier.width(48.dp))
            Row {
                Button(onClick = {
                    if (healthBar.intValue >0) {
                        direction.value = "West"
                        if (Random.nextBoolean()) {
                            treasureFound.intValue += 1
                            stormOrTreasure.value = "!! Found Treasure !!"
                        } else {
                            healthBar.intValue -= 5
                            stormOrTreasure.value = "Encountered Storm "
                        }
                    }
                }) {
                    Text(text = "Sail West")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CaptainGamePreview(){
    CaptainGameTheme {
        CaptainGame()
    }
}
