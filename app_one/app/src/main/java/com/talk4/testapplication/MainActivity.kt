package com.talk4.testapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.talk4.testapplication.MainActivity.Companion.TAG
import com.talk4.testapplication.ui.theme.TestApplicationTheme

class MainActivity : ComponentActivity() {
    private val viewModel: MainViewModel  by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                   // modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android", buttonClick = viewModel::taskOne)
                }
            }
        }
    }

    companion object {
        val TAG : String = "TestApp"
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier, buttonClick: () -> Unit = {}) {
    Button( onClick = {
        buttonClick()
        Log.i(TAG, "Buttonclick done." + Thread.currentThread().name)
                      }, enabled = true) {
        Text(
            text = "Hello $name!",
            modifier = modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TestApplicationTheme {
        Greeting("Android")
    }
}