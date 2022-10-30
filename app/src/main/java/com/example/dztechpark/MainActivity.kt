package com.example.dztechpark

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentById(R.id.container) == null)
            supportFragmentManager.beginTransaction().add(R.id.container, ListFragment()).commit()
    }
}