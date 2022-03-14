package com.example.dailyquiz

import java.util.ArrayList

object constants{
    fun getquestions():ArrayList<questions>{
        val questionsList= ArrayList<questions>()

        val que1= questions(1,"which country does this flag represent?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "australia",
            "armenia",
            "Austria",
            1
        )
        questionsList.add(que1)
        val que2=questions(2,"which country does this flag represent?",R.drawable.ic_flag_of_australia,
            "Argentina",
            "australia",
            "armenia",
            "Austria",
            2
        )
        questionsList.add(que2)
        val que3=questions(3,"which country does this flag represent?",R.drawable.ic_flag_of_belgium,
            "Argentina",
            "australia",
            "Belgium",
            "Austria",
            3
        )
        questionsList.add(que3)
        val que4= questions(4,"which country does this flag represent?",R.drawable.ic_flag_of_brazil,
            "USA",
            "India",
            "Belgium",
            "Brazil",
            4
        )
        questionsList.add(que4)

        val que5= questions(5,"which country does this flag represent?",R.drawable.ic_flag_of_denmark,
            "USA",
            "India",
            "Denmark",
            "Brazil",
            3
        )
        questionsList.add(que5)
        val que6=questions(6,"which country does this flag represent?",R.drawable.ic_flag_of_fiji,
            "Libiya",
            "Fiji",
            "Denmark",
            "Armenia",
            2
        )
        questionsList.add(que6)
        val que7=questions(7,"which country does this flag represent?",R.drawable.ic_flag_of_germany,
        "Pakistan",
        "Afghanistan",
            "Germany",
            "Fiji",
            3


        )
        questionsList.add(que7)
        val que8=questions(8,"which country does this flag represent?",R.drawable.ic_flag_of_india,
            "India",
            "Afghanistan",
            "Germany",
            "Fiji",
            1
        )
        questionsList.add(que8)
        val que9=questions(9,"which country does this flag represent?",R.drawable.ic_flag_of_kuwait,
            "Pakistan",
            "Afghanistan",
            "Kuwait",
            "UAE",
            2
        )
        questionsList.add(que9)
        val que10=questions(10,"which country does this flag represent?",R.drawable.ic_flag_of_new_zealand,
            "India",
            "Afghanistan",
            "NewZealand",
            "Fiji",
            3
        )
        questionsList.add(que10)

        return questionsList




    }

}