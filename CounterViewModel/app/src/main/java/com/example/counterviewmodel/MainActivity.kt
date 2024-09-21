package com.example.counterviewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview



class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FeatherAndroidTasksTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                ) {
                    CounterApp(counterViewModel)
                }
            }
        }
    }
}


@Composable
fun CounterApp(viewModel: CounterViewModel) {
    Column {
        Text("Counter Value: ${viewModel.count.value}")
        Button(onClick = { viewModel.increment() }) {
            Text("Increment")
        }
        Button(onClick = { viewModel.decrement() }) {
            Text("Decrement")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterApp(function: () -> Unit) {
        CounterApp(viewModel = CounterViewModel())
}
