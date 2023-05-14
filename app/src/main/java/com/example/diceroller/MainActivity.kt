package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.Random

class MainActivity : AppCompatActivity() {

    lateinit var diceImage : ImageView
    lateinit var resultText : TextView
    lateinit var developerName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton : Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rollDice()
        }
        diceImage = findViewById(R.id.dice_image)
        resultText = findViewById(R.id.result_text)
        developerName = findViewById(R.id.Developer)
    }

    private fun rollDice() {
        val randomInt = Random().nextInt(6)+1
        val drawableResource = when(randomInt)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableHeart = when(randomInt)
        {
            1 -> "❤️"
            2 -> "♥️"
            3 -> "💛"
            4 -> "💚"
            5 -> "💜"
            else -> "💖"
        }
        developerName.text = "Made with $drawableHeart by Harsh"
        diceImage.setImageResource(drawableResource)
        if(randomInt == 6){
            Toast.makeText(this,"A Six!",Toast.LENGTH_SHORT).show()
        }
        resultText.text = "You got $randomInt"
    }
}