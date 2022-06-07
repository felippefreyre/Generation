package com.generation.myapplication

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("Ciclo", "OnCreate")
    }

    override fun onStart(){
        super.onStart()
        Log.d("Ciclo","onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Ciclo","onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("Ciclo","OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("Ciclo","onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Ciclo", "onDestroy")
    }
}