package com.example.pr1_3button

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class SecondActivity : AppCompatActivity() {
    private lateinit var textView_random: TextView
    private lateinit var textView_label: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_random)

        textView_random = findViewById(R.id.textView_random)
        textView_label = findViewById(R.id.textView_label)

        showRandomNumber()
    }

    companion object{
        const val TOTAL_COUNT = "total_count"
    }

    fun showRandomNumber() {
        val count = intent.getIntExtra(TOTAL_COUNT, 0)
        val random = Random(0)
        var randomInt = 0
        if (count >= 0) {
            randomInt = random.nextInt(count + 1)
        } else {
            randomInt = random.nextInt(count, 1)
        }
        textView_random.text = Integer.toString(randomInt)
        textView_label.text = getString(R.string.random_description, count)
    }
}