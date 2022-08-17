package com.rmanzur.quizappef

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val prgBar = findViewById<ProgressBar>(R.id.progressBar)
        val tvprog = findViewById<TextView>(R.id.tv_progress)
        val tvquest = findViewById<TextView>(R.id.tv_question)
        val ivimg = findViewById<ImageView>(R.id.iv_image)
        val tvop1 = findViewById<TextView>(R.id.tv_option_one)
        val tvop2 = findViewById<TextView>(R.id.tv_option_two)
        val tvop3 = findViewById<TextView>(R.id.tv_option_three)
        val tvop4 = findViewById<TextView>(R.id.tv_option_four)

        val questionsList = Constants.getQuestions()
        Log.i("Total de preguntas: ","${questionsList.size}")

        val currentPos = 1
        val question: Question? ? = questionsList[currentPos - 1]

        prgBar.progress = currentPos
        tvprog.text = "$currentPos" + "/" + prgBar.max
        tvquest.text=question!!.question
        ivimg.setImageResource(question.image)
        tvop1.text = question.optionOne
        tvop2.text = question.optionTwo
        tvop3.text = question.optionThree
        tvop4.text = question.optionFour

    }
}