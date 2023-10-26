package com.example.homework_2_numberconvertor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val entranceText = findViewById<TextView>(R.id.entranceText)
        val outputText = findViewById<TextView>(R.id.outputText)
        val userInputString = findViewById<EditText>(R.id.inputText)
        val btn = findViewById<Button>(R.id.btn)

        entranceText.text = "შეიყვანეთ რიცხვი [1-1000] შუალედიდან"
        btn.setOnClickListener {
            val userNumber: Int = userInputString.text.toString().toInt()
            val convertedNumber: String = covertToString(userNumber)
            outputText.text = "შენი შეყვანილი რიცხვია: \n$convertedNumber"
        }
    }

    fun covertToString(number: Int): String {
        val firstNinteen =  arrayOf(
            "", "ერთ", "ორ", "სამ", "ოთხ", "ხუთ",
            "ექვს", "შვიდ", "რვა", "ცხრა", "ათ",
            "თერთმეტ", "თორმეტ", "ცამეტ", "თოთხმეტ", "თხუთმეტ",
            "თექვსმეტ", "ჩვიდმეტ", "თვრამეტ", "ცხრამეტ"
        )
        val tenAmount = arrayOf(
            "", "ოც", "ორმოც", "სამოც", "ოთხმოც", "ას"
        )


        var inputNumber: Int = number
        val indexOfTens: Int
        val indexOfHundreds: Int
        var returnString = ""


        if(inputNumber / 100 != 0) {
            indexOfHundreds = inputNumber / 100
            if (indexOfHundreds == 1) {
                returnString = ""
            } else {
                returnString += firstNinteen[indexOfHundreds]
            }
            returnString += if(inputNumber % 100 == 0) "ას" else "ას "
            inputNumber -= indexOfHundreds * 100
        }
        if(inputNumber / 20 != 0) {
            indexOfTens = inputNumber / 20
            returnString += tenAmount[indexOfTens]
            if(inputNumber % 20 != 0) {
                returnString += "და"
            }
            inputNumber -= indexOfTens * 20
        }
        if(inputNumber != 0) {
            returnString += firstNinteen[inputNumber]
        }

        return if(inputNumber == 8 || inputNumber == 9) {
            returnString
        } else {
            returnString + "ი"
        }
    }
}