package com.rmanzur.quizappef

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPos: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectOptionPos: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUsername: String? = null
    private lateinit var btnSub: Button
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
        mUsername = intent.getStringExtra(Constants.USERNAME)
        btnSub = findViewById<Button>(R.id.btn_submit)
        prgBar = findViewById<ProgressBar>(R.id.progressBar)
        tvprog = findViewById<TextView>(R.id.tv_progress)
        tvquest = findViewById<TextView>(R.id.tv_question)
        ivimg = findViewById<ImageView>(R.id.iv_image)
        tvop1 = findViewById<TextView>(R.id.tv_option_one)
        tvop2 = findViewById<TextView>(R.id.tv_option_two)
        tvop3 = findViewById<TextView>(R.id.tv_option_three)
        tvop4 = findViewById<TextView>(R.id.tv_option_four)
        mQuestionList = Constants.getQuestions()
        setQuestion()

        tvop1.setOnClickListener(this)
        tvop2.setOnClickListener(this)
        tvop3.setOnClickListener(this)
        tvop4.setOnClickListener(this)

        btnSub.setOnClickListener(this)
    }

    private fun setQuestion(){

        enableAnswers()
        val question = mQuestionList!![mCurrentPos-1]

        defaultOptionsView()

        if(mCurrentPos==mQuestionList!!.size){
            btnSub.text="Terminar"
        }else{
            btnSub.text="Confirmar"
        }

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

    private fun disableAnswers(){
        tvop1.isEnabled = false
        tvop2.isEnabled = false
        tvop3.isEnabled = false
        tvop4.isEnabled = false
    }

    private fun enableAnswers(){
        tvop1.isEnabled = true
        tvop2.isEnabled = true
        tvop3.isEnabled = true
        tvop4.isEnabled = true
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
            R.id.btn_submit ->{
                disableAnswers()
                if(mSelectOptionPos==0){
                    mCurrentPos ++
                    when{
                        mCurrentPos<=mQuestionList!!.size -> {
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USERNAME, mUsername)
                            intent.putExtra(Constants.CORRECTANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTALQUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPos-1)
                    if(question!!.correctAnswer!=mSelectOptionPos){
                        viewAnswer(mSelectOptionPos, R.drawable.wrong_option_border_bg)
                    }else{
                        mCorrectAnswers ++
                    }
                    viewAnswer(question.correctAnswer, R.drawable.correct_option_border_bg)
                    if(mCurrentPos == mQuestionList!!.size){
                        btnSub.text = "Terminar"
                    }else{
                        btnSub.text = "Siguiente pregunta"
                    }
                    mSelectOptionPos = 0
                }
            }
        }
    }

    private fun viewAnswer(answer: Int, drawableView: Int){
        when(answer){
            1 ->{
                tvop1.background = ContextCompat.getDrawable(this,
                drawableView)
            }
            2 ->{
                tvop2.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            3 ->{
                tvop3.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            4 ->{
                tvop4.background = ContextCompat.getDrawable(this,
                    drawableView)
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