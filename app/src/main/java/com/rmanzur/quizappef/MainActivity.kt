package com.rmanzur.quizappef

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        @Suppress("DEPRECATION")
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        val startBtn = findViewById<Button>(R.id.btn_start)
        val edtName = findViewById<EditText>(R.id.et_name)

        startBtn.setOnClickListener {
            if(edtName.text.toString().isEmpty()){
                Toast.makeText(this, "Ingrese su nombre", Toast.LENGTH_SHORT).show()
            }else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USERNAME, edtName.text.toString())
                startActivity(intent)
                finish()
            }
        }

    }
}