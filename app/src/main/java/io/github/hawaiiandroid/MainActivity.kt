package io.github.hawaiiandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/**
 * Beim Aufruf der App wird der Knopf mit einer Logik versehen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.rollButton)

        // Setzen eines Listeners, der beim Drücken auf dem Knopf reagiert
        rollButton.setOnClickListener { rollDice() }
    }

    /**
     * Beim Drücken des Knopfes wird eine zufällige Zahl generiert und auf dem
     * Bildschirm angezeigt
     */
    private fun rollDice() {
        val diceNumber1: TextView = findViewById(R.id.diceNumber1)
        val diceNumber2: TextView = findViewById(R.id.diceNumber2)

        diceNumber1.text = Dice(6).roll().toString()
        diceNumber2.text = Dice(6).roll().toString()
    }
}

/**
 * Zusätzliche Klasse, die eine zufällige Würfelzahl unter Angabe der Seitenanzahl generiert
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        // Rückgabe einer Zahl zwischen 1 und Parameter numSides
        return (1..numSides).random()
    }
}