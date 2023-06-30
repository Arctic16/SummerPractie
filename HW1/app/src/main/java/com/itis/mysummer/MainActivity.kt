package com.itis.mysummer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var clickButton: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val resultText = findViewById<TextView>(R.id.textView)
        clickButton = findViewById<Button>(R.id.button)
        clickButton?.setOnClickListener {
            resultText.text = kkal()
        }
    }
    fun kkal() : String {
        val editTextName = findViewById<EditText>(R.id.textInputEditText)
        val editTextHeight = findViewById<EditText>(R.id.rost)
        val editTextWeight = findViewById<EditText>(R.id.ves)
        val editTextAge = findViewById<EditText>(R.id.age)
        val name = editTextName.text.toString()
        val height = editTextHeight.text.toString()
        val weight = editTextWeight.text.toString()
        val age = editTextAge.text.toString()

        var str: String = "Данные введедены некорректно!"
        var boolean: Boolean = false
        if(!height.isEmpty() && name != "Введите имя"
            && !age.isEmpty()
            && !weight.isEmpty()){
            if (name.length in 1.. 50 &&  height.toInt() in 1..250
                || weight.toDouble() in 1.00..250.00 && age.toInt() in 1..150) {
                boolean = true
            }
        }
        if (boolean) {
            val otvet: Double = (600 + 12.5 * weight.toDouble() + 5 * height.toInt() - 5.75 * age.toInt())
            str = "$name : $otvet"
        }
        return str
    }
}
