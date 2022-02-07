package com.alcherainc.app.mvp

class Presenter : IPresenter {
    private var view: IPresenter.View
    private var model: Model

    constructor(view: IPresenter.View) {
        this.view = view
        this.model = Model()
    }

    override fun confirm() {
        if (view != null) {
            view.setText(model.ButtonClick())
        }
    }
}