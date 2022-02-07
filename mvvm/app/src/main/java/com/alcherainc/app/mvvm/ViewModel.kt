package com.alcherainc.app.mvvm

import android.app.Activity
import android.widget.TextView

class ViewModel {
    lateinit var activity: Activity
    lateinit var model: Model
    lateinit var textView: TextView

    constructor(activity: Activity) {
        this.activity = activity
        this.model = Model()
        initView()
    }

    fun initView() {
        textView = activity.findViewById(R.id.tv_title)
        textView.setOnClickListener {
            textView.text = model.ButtonClick()
        }
    }
}