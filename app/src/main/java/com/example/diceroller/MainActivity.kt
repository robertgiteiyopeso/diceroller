package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.slider.Slider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val slider: Slider = findViewById(R.id.slider)
        slider.addOnChangeListener { cslider, value, fromUser -> changeDie(slider, value, fromUser)  }

        val rollButton: Button = findViewById(R.id.roll_Button)
        rollButton.setOnClickListener { rollDice(slider.value.toInt()) }
    }

    private fun rollDice(size: Int) {
        //Toast.makeText(this, "ai apasat", Toast.LENGTH_SHORT).show()
        val randomInt = (1..size).random()
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = randomInt.toString()
    }

    private fun changeDie(slider: Slider, value: Float, fromUser: Boolean) {
        val diceSize: TextView = findViewById(R.id.dice_size)
        diceSize.setText("Rolling a ${value.toInt()} sided die")
    }
}