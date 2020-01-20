package com.example.numbertowordconvertornew

import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

class CheckNumberRangeTest{

    private lateinit var presenter : NumberToWordConvertorPresenter
    private lateinit var view : NumberToWordConvertorPresenter.View

    @Before
    fun setup() {
        presenter = NumberToWordConvertorPresenter()
        view = mock()
        presenter.attachView(view)
    }

    @Test
    fun check_withEmptyNumber_callShowConvertedWord(){
        presenter.convertNumberToWord("0000")

        verify(view).checkNumberRange()
    }
}