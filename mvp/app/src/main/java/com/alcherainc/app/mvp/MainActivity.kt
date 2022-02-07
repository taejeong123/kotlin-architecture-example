package com.alcherainc.app.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity(), IPresenter.View {

    lateinit var presenter: Presenter
    lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = Presenter(this)

        textView = findViewById(R.id.tv_title)
        textView.setOnClickListener {
            presenter.confirm()
        }
    }

    override fun setText(text: String) {
        textView.text = text
    }
}