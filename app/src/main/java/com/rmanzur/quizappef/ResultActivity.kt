package com.rmanzur.quizappef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val btnFn = findViewById<Button>(R.id.btn_finish)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvScore = findViewById<TextView>(R.id.tv_score)
        val username = intent.getStringExtra(Constants.USERNAME)
        tvName.text = username
        val totalQuestions = intent.getIntExtra(Constants.TOTALQUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECTANSWERS, 0)

        tvScore.text = "Tu puntaje fue $correctAnswers de $totalQuestions"

        btnFn.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}