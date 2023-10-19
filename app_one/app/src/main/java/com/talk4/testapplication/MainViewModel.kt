package com.talk4.testapplication

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.talk4.testapplication.MainActivity.Companion.TAG
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Thread.sleep
import java.util.concurrent.Executors

class MainViewModel: ViewModel() {
    private val testScope: CoroutineScope = CoroutineScope(
        Executors.newSingleThreadExecutor().asCoroutineDispatcher()
    )

    fun taskOne() = testScope.launch {
        Log.i(TAG, "taskOne() at 1:" + Thread.currentThread().name)
        viewModelScope.launch {
            delay(1000)
            Log.i(TAG, "taskOne() at 2:" + Thread.currentThread().name)
            testScope.launch {
                Log.i(TAG, "taskOne() at 4:" + Thread.currentThread().name)
            }
        }
        Log.i(TAG, "taskOne() at 3:" + Thread.currentThread().name)
        testScope.launch {
            Log.i(TAG, "taskOne() at 5:" + Thread.currentThread().name)
        }
        delay(1000)
    }
}