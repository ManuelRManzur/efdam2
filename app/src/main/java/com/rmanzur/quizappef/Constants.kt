package com.rmanzur.quizappef

object Constants {
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val q1 = Question(1,
            "A qué país le pertenece esta bandera?",
        R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Uruguay",
            "Nicaragua",
            1)
        questionsList.add(q1)
        val q2 = Question(2,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_australia,
            "Reino Unido",
            "Australia",
            "Uruguay",
            "Estados Unidos",
            2)
        questionsList.add(q2)
        val q3 = Question(3,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_belgium,
            "Bélgica",
            "Alemania",
            "Italia",
            "España",
            1)
        questionsList.add(q3)
        val q4 = Question(4,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Ecuador",
            "Venezuela",
            "Colombia",
            1)
        questionsList.add(q4)
        val q5 = Question(5,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_fiji,
            "Fiyi",
            "Australia",
            "Reino Unido",
            "Islandia",
            1)
        questionsList.add(q5)
        val q6 = Question(6,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Australia",
            "Dinamarca",
            "Nicaragua",
            3)
        questionsList.add(q6)
        val q7 = Question(7,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_germany,
            "Bélgica",
            "Rusia",
            "Alemania",
            "Ucrania",
            3)
        questionsList.add(q7)
        val q8 = Question(8,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_india,
            "Italia",
            "Irlanda",
            "Dinamarca",
            "India",
            4)
        questionsList.add(q8)
        val q9 = Question(9,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_kuwait,
            "Ucrania",
            "Kuwait",
            "Republica del Congo",
            "Italia",
            2)
        questionsList.add(q9)
        val q10 = Question(10,
            "A qué país le pertenece esta bandera?",
            R.drawable.ic_flag_of_new_zealand,
            "Argentina",
            "Australia",
            "Reino Unido",
            "Nueva Zelanda",
            4)
        questionsList.add(q10)
        return questionsList
    }
}