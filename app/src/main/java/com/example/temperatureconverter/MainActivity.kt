package com.example.temperatureconverter

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private val radioGroup: RadioGroup? = null
    private var radioButton: RadioButton? = null
    private var btnDisplay: Button? = null
    private var textField: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addListenerOnButton();
    }

    fun addListenerOnButton() {

        var radioGroup: RadioGroup = findViewById(R.id.temperatureRadioGroup);
        var btnDisplay: Button = findViewById(R.id.button);

        btnDisplay.setOnClickListener {
                var selectedId:Int = radioGroup.checkedRadioButtonId;

                var radioButton:RadioButton = findViewById(selectedId);
                var textField:EditText = findViewById(R.id.editText)

                var value:Double =
                    when (selectedId) {
                    R.id.radioButton -> (textField.text.toString().toDouble().times(1.8)) + 32
                    R.id.radioButton2 -> (textField.text.toString().toDouble().minus(32.0)) / 1.8
                        else -> 0.0 
                }

                Toast.makeText(
                    this,
                    "value: ${value}", Toast.LENGTH_SHORT
                ).show();
        };
    }
}
