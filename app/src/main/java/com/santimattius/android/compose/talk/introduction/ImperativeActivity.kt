package com.santimattius.android.compose.talk.introduction

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.santimattius.android.compose.talk.R

class ImperativeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imperative)

        var counter = 0

        val text = findViewById<TextView>(R.id.text_view)
        text.text = "$counter"

        val button = findViewById<Button>(R.id.button)
        button.text = getString(R.string.text_button)
        button.setOnClickListener {
            counter += 1
            //Update textView
            text.text = "$counter"
        }
    }
}