package com.example.numbertowordconvertornew

import android.view.View

class NumberToWordConvertorPresenter {

    private var view: View? = null

    fun attachView(view: View) {
        this.view = view
    }

    fun detachView() {
        this.view = null
    }

    fun convertNumberToWord(number: String) {
        if (number.trim().isBlank() || number == "0") {
            view?.checkNumberRange()
        } else {
            view?.showConvertedWord(number)
        }
    }

    interface View {
        fun checkNumberRange()
        fun showConvertedWord(query: String)
    }
}