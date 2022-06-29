package com.generation.viewmodelelivedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.generation.viewmodelelivedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var mainWiewModel: MainWiewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

         mainWiewModel = ViewModelProvider(this).get(MainWiewModel::class.java)

         mainWiewModel.cont.observe(this){
             binding.textResultado.text = it.toString()
         }
        binding.buttonClique.setOnClickListener(){
            mainWiewModel.addNum()


        }

    }



}


