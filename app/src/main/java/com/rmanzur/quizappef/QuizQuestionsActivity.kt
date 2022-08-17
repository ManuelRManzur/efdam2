package com.rmanzur.quizappef

import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPos: Int = 0
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectOptionPos: Int = 0
    private lateinit var prgBar: ProgressBar
    private lateinit var tvprog: TextView
    private lateinit var tvquest: TextView
    private lateinit var ivimg: ImageView
    private lateinit var tvop1: TextView
    private lateinit var tvop2: TextView
    private lateinit var tvop3: TextView
    private lateinit var tvop4: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
        prgBar = findViewById<ProgressBar>(R.id.progressBar)
        tvprog = findViewById<TextView>(R.id.tv_progress)
        tvquest = findViewById<TextView>(R.id.tv_question)
        ivimg = findViewById<ImageView>(R.id.iv_image)
        tvop1 = findViewById<TextView>(R.id.tv_option_one)
        tvop2 = findViewById<TextView>(R.id.tv_option_two)
        tvop3 = findViewById<TextView>(R.id.tv_option_three)
        tvop4 = findViewById<TextView>(R.id.tv_option_four)
        mQuestionList = Constants.getQuestions()
        setQuestion(prgBar,tvprog,tvquest,ivimg,tvop1,tvop2,tvop3,tvop4)

        tvop1.setOnClickListener(this)
        tvop2.setOnClickListener(this)
        tvop3.setOnClickListener(this)
        tvop4.setOnClickListener(this)

    }

    private fun setQuestion(prgBar:ProgressBar,
                            tvprog:TextView,
                            tvquest:TextView,
                            ivimg: ImageView,
                            tvop1: TextView,
                            tvop2: TextView,
                            tvop3: TextView,
                            tvop4: TextView
    ){
        mCurrentPos = 1
        val question = mQuestionList!![mCurrentPos-1]

        defaultOptionsView()

        prgBar.progress = mCurrentPos
        tvprog.text = "$mCurrentPos" + "/" + prgBar.max
        tvquest.text=question!!.question
        ivimg.setImageResource(question.image)
        tvop1.text = question.optionOne
        tvop2.text = question.optionTwo
        tvop3.text = question.optionThree
        tvop4.text = question.optionFour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tvop1)
        options.add(1,tvop2)
        options.add(2,tvop3)
        options.add(3,tvop4)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_option_one ->{
                selectedOptionsView(tvop1, 1)
            }
            R.id.tv_option_two ->{
                selectedOptionsView(tvop2, 2)
            }
            R.id.tv_option_three ->{
                selectedOptionsView(tvop3, 3)
            }
            R.id.tv_option_four ->{
                selectedOptionsView(tvop4, 4)
            }
        }
    }

    private fun selectedOptionsView(tv:TextView,selectedOptionNum: Int){
        defaultOptionsView()
        mSelectOptionPos = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)
    }
}