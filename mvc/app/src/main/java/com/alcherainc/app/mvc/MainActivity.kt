package com.alcherainc.app.mvc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var model: Model

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.tv_title)

        // Controller
        model = Model()
        textView.setOnClickListener {
            textView.text = model.ButtonClick()
        }

    }
}