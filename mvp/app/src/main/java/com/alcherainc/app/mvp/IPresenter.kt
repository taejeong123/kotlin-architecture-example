package com.alcherainc.app.mvp

interface IPresenter {
    fun confirm()
    interface View {
        fun setText(text: String)
    }
}