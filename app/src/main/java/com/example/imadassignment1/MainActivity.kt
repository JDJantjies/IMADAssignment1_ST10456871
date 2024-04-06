package com.example.imadassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // finding the ids in the xml file
        var ageEditText = findViewById<TextView>(R.id.ageEditText)
        var generateButton = findViewById<Button>(R.id.generateButton)
        var resultTextView = findViewById<TextView>(R.id.factTextView)
        var clearButton = findViewById<Button>(R.id.clearButton)

        // clear button function
        clearButton.setOnClickListener {
            resultTextView.text = ""
            ageEditText.text.clear()
        }
        // finding the age using the generate button
        generateButton.setOnClickListener {
            val age = ageEditText.text.toString().toIntOrNull()
            if (age != null) {
                val historicalFigure = getHistoricalFigure(age)
                resultTextView.text = historicalFigure ?: "No historical figure found."
            } else {
                resultTextView.text = "Please enter a valid age."
            }
            if (age!! <= 20) {
                val historicalFigure = getHistoricalFigure(age)
                resultTextView.text = historicalFigure ?: "Not within range."
            } else {
                if (age >= 100) {
                    val historicalFigure = getHistoricalFigure(age)
                    resultTextView.text = historicalFigure ?: "Not within range."
                }
            }
        }
    }
    // creating a private function for a list of strings
    private fun getHistoricalFigure(age: Int): String? {
        val historicalFigures = mapOf( // creating a variable to use to get a string for an inputted number
            29 to "Heath Ledger died at the age 29 and was most famous for his role as Joker in 'The Dark Knight'",
            22 to "Aaliyah was a popular pop singer in the 90s and early 00s who passed away at age 22",
            30 to "MLK, most known for his 'I have a dream' speech died at the age of 30",
            39 to "Malcom X was an islamic spokesperson in the 50s and 60s and died at 39 years of age",
            46 to "JFK was assassinated at the age of 46",
            56 to "Beethoven, the composer of Fur Elise, died at age 56",
            67 to "George Washington, the first president of the USA, died at the age of 67",
            74 to "Mohammed Ali, widely regarded as the greatest boxer of all time, passed away at 74 years old",
            82 to "Pele died at 82 years old and is widely regarded as the greatest brazilian footballer of all time",
            95 to "Nelson Mandela was the first black president of South Africa and passed away at 95 years old",
        )
        return historicalFigures[age] // retrieves the variable
    }
}

private fun CharSequence.clear() {
    TODO("Not yet implemented")
}




