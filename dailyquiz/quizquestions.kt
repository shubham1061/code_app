package com.example.dailyquiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.INotificationSideChannel
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.example.dailyquiz.constants.getquestions
import kotlinx.android.synthetic.main.activity_quizquestions.*
import kotlin.math.log
import kotlin.math.max

class quizquestions : AppCompatActivity(),View.OnClickListener {

    var mcurrentposition: Int = 1
    var mquestionslist: ArrayList<questions>? = null
    var mselectedOptionposition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            this.supportActionBar!!.hide()
        } catch (e: NullPointerException) {
        }
        setContentView(R.layout.activity_quizquestions)



        mquestionslist = constants.getquestions()
        setquestion()

        tv_optionone.setOnClickListener(this)
        tv_optiontwo.setOnClickListener(this)
        tv_optionthree.setOnClickListener(this)
        tv_optionfour.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {

            R.id.tv_optionone -> {

                selectedoptionview(tv_optionone, 1)
            }

            R.id.tv_optiontwo -> {

                selectedoptionview(tv_optiontwo, 2)
            }

            R.id.tv_optionthree -> {

                selectedoptionview(tv_optionthree, 3)
            }

            R.id.tv_optionfour -> {

                selectedoptionview(tv_optionfour, 4)
            }
            R.id.btn_submit -> {
                if (mselectedOptionposition == 0) {
                      Toast.makeText(
                        this,
                        "choose an option",
                      Toast.LENGTH_SHORT
                    ).show()



                    when {
                        mcurrentposition <= mquestionslist!!.size -> {
                            setquestion()
                        }
                        else -> {
                            Toast.makeText(
                                this,
                                "You have successfully completed the quiz",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                } else {
                    val Question = mquestionslist?.get(mcurrentposition - 1)
                    if (Question!!.correctoption != mselectedOptionposition) {
                        answerview(mselectedOptionposition, R.drawable.wrong_option_border_bg)
                        answerview(Question.correctoption, R.drawable.correct_option_border_bg)
                    }else {
                        answerview(Question.correctoption, R.drawable.correct_option_border_bg)
                    }

                    if (mcurrentposition == mquestionslist!!.size) {
                        btn_submit.text = "FINISH"
                    }else{
                        btn_submit.text = "GO TO NEXT QUESTION"}

                    mselectedOptionposition = 0
                


                }
            }
        }

    }



    private fun setquestion(){

        val ques= mquestionslist!!.get(mcurrentposition-1)
        defaultview()
        if (mcurrentposition== mquestionslist!!.size){
            btn_submit.text="FINISH"
        }else{
            btn_submit.text="SUBMIT"
        }
        pb_bar.progress= mcurrentposition
        tv_progress.text="$mcurrentposition"+"/"+ pb_bar.max
        tv_question.text= ques.question
        iv_image1.setImageResource(ques.image)
        tv_optionone.text = ques.optionone
        tv_optiontwo.text = ques.optiontwo
        tv_optionthree.text = ques.optionthree
        tv_optionfour.text = ques.optionfour


    }

    private fun selectedoptionview(tv:TextView,selectedoptionnum:Int) {


        defaultview()
        mselectedOptionposition=selectedoptionnum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this, R.drawable.selected
        )
    }
    private fun defaultview(){


        val options = ArrayList<TextView>()
        options.add(0, tv_optionone)
        options.add(1, tv_optiontwo)
        options.add(2, tv_optionthree)
        options.add(3, tv_optionfour)

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this,
                R.drawable.bacgroundtv)
        }

    }

    private fun answerview(Answer: Int, Drawableview: Int) {

        when (Answer) {
            1 -> {
                tv_optionone.background = ContextCompat.getDrawable(this, Drawableview)
            }
            2 -> {
                tv_optiontwo.background = ContextCompat.getDrawable(this, Drawableview)
            }
            3 -> {
                tv_optionthree.background = ContextCompat.getDrawable(this, Drawableview)
            }
            4 -> {
                tv_optionfour.background = ContextCompat.getDrawable(this, Drawableview)
            }
        }

    }


}