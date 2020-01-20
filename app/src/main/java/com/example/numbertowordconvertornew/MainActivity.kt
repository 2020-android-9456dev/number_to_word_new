package com.example.numbertowordconvertornew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity(), NumberToWordConvertorPresenter.View {

    private val presenter: NumberToWordConvertorPresenter = NumberToWordConvertorPresenter()

    lateinit var tvWord: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main);

        presenter.attachView(this)

        val etNumber = findViewById<EditText>(R.id.etNumber);
        val btnConvert = findViewById<Button>(R.id.btnConvert);
        tvWord = findViewById<TextView>(R.id.tvWord);

        btnConvert.setOnClickListener {
            presenter.convertNumberToWord(etNumber.text.toString());
        }

        etNumber.setOnEditorActionListener() { v, actionId, event ->
            if(actionId == EditorInfo.IME_ACTION_DONE) {
                presenter.convertNumberToWord(etNumber.text.toString());
                true
            }
            false
        }
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showConvertedWord(number: String) {
        Toast.makeText(applicationContext,"Here we need to apply login of final login of conversion", Toast.LENGTH_SHORT).show();
    }

    override fun checkNumberRange() {
        tvWord.setText("");
        Toast.makeText(applicationContext,R.string.number_range_error_msg, Toast.LENGTH_SHORT).show();
    }
}
