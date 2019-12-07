package com.akshaym.snipper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

private const val BASE_URL = "https://github-trending-api.now.sh/"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}

