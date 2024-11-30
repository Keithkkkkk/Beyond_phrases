package com.example.beyond_phrases

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.content.Intent
import androidx.activity.enableEdgeToEdge
import android.widget.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val imageView: ImageView = findViewById(R.id.imageView2)
        imageView.setImageResource(R.drawable.learning)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener{
            val intent = Intent(this, LessonsActivity::class.java)
            startActivity(intent)
        }
    }
}
