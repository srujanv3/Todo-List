package com.blogspot.svdevs.flows.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.blogspot.svdevs.flows.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Dispatchers.Default
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var flow: Flow<Int>

    private lateinit var flowOne: Flow<String>
    private lateinit var flowTwo: Flow<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpFlows()
    }

    private fun setUpFlows() {
//        flow = flow {
//            Log.d("TAG", "setUpFlows: Start flow")
//            (0..10).forEach { value ->
//                kotlinx.coroutines.delay(500)
//                Log.d("TAG", "setUpFlows: emitting $value")
//                emit(value)
//            }
//        }.map {
//            it * it
//        }.flowOn(Dispatchers.Default)

        flowOne = flowOf("Nicole","Eva","Kendra").onEach { delay(400) }.flowOn(Dispatchers.Default)
        flowTwo = flowOf("Noelle","Vanessa","Grey").onEach { delay(500) }.flowOn(Dispatchers.Default)

    }
}