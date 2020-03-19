package com.furkan.cs473mobiledeviceprogramming

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_quiz.*

/**
 * A simple [Fragment] subclass.
 */
class QuizFragment : Fragment() {
    lateinit var dbcon: SQLController
    var quiz = ArrayList<Question>()
    var position = 0
    var questions = ArrayList<String>()
    var correctAnswers = ArrayList<String>()
    var userAnswers = ArrayList<String>()
    var userScore = 0;
    var emptyAnswerCounter = 0;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        dbcon = SQLController(context!!)
        dbcon.open()

      /*   Questions are inserted to database only once.
        dbcon.insertData(
            "1 - Which one is not an android layout?",
            "a) Relative Layout", "b) Linear Layout", "c) Exponential Layout", "c"
        )
        dbcon.insertData(
            "2 - Android is developed by",
            "a) Google", "b) Yahoo", "c) Microsoft", "a"
        )
        dbcon.insertData(
            "3 - Android is based on which Kernel?",
            "a) Windows", "b) Linux", "c) Mac", "b"
        )
        dbcon.insertData(
            "4 - Which media format is not supported in Android?",
            "a) MP4", "b) MPEG", "c) AVI", "c"
        )
        dbcon.insertData(
            "5 - In which directory XML Layout files are stored?",
            "a) /res/layout", "b) /assets", "c) /src", "a"
        )
        dbcon.insertData(
            "6 - View Pages used for?",
            "a) Swiping Activities", "b) Swiping Fragments", "c) Paging list items", "b"
        )
        dbcon.insertData(
            "7 - Which is not an android programming language?",
            "a) kotlin", "b) java", "c) php", "c"
        )
        dbcon.insertData(
            "8 - Which one is not a dialog?",
            "a) Toast Dialog", "b) Datepicker Dialog", "c) Alert Dialog", "a"
        )
        dbcon.insertData(
            "9 - Fragments could be considered as?",
            "a) SubService", "b) SubActivity", "c) SubClass", "b"
        )
        dbcon.insertData(
            "10 - Runtime permissions started with which android version codename?",
            "a) Cupcake", "b) Pie", "c) Marshmallow", "c"
        )
        dbcon.insertData(
            "11 - Which folder to store images?",
            "a) drawable", "b) layout", "c) values", "a"
        )
        dbcon.insertData(
            "12 - How to show large list efficiently?",
            "a) ListView", "b) RecyclerView", "c) ImageView", "b"
        )
        dbcon.insertData(
            "13 - Which one is not an intent category?",
            "a) Implicit", "b) Explicit", "c) Internal", "c"
        )
        dbcon.insertData(
            "14 - Which one is not permission category?",
            "a) Crucial", "b) Normal", "c) Dangerous", "a"
        )
        dbcon.insertData(
            "15 - Which one is not an Android component?",
            "a) Activity", "b) Fragment", "c) Service", "b"
        ) */

        val cursor = dbcon.readData()


        cursor.moveToFirst()
        while (!(cursor.isAfterLast())) {
            quiz.add(
                Question(
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5)
                )
            )
//            mArrayList.add(mCursor.getWhateverTypeYouWant(WHATEVER_COLUMN_INDEX_YOU_WANT))
            cursor.moveToNext()
        }

        //load correct answers list
        for (i in 0 until 15) {
            if (quiz.get(i).correctAnswer.equals("a")) {
                correctAnswers.add(quiz.get(i).answerA)
            } else if (quiz.get(i).correctAnswer.equals("b")) {
                correctAnswers.add(quiz.get(i).answerB)
            } else {
                correctAnswers.add(quiz.get(i).answerC)
            }
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //load question
        var question: Question = quiz.get(position)
        txtQuestion.text = question.question
        radioA.text = question.answerA
        radioB.text = question.answerB
        radioC.text = question.answerC

        buttonNext.setOnClickListener { view ->

            //add user answer
            if (radioA.isChecked) {
                userAnswers.add(question.answerA)
            } else if (radioB.isChecked) {
                userAnswers.add(question.answerB)
            } else if (radioC.isChecked) {
                userAnswers.add(question.answerC)
            } else {
                userAnswers.add("No answer has given.")
                emptyAnswerCounter++
            }

            //increment position
            position++

            if (!(position >= 15)) {
                question = quiz.get(position)
                txtQuestion.text = question.question
                radioA.text = question.answerA
                radioB.text = question.answerB
                radioC.text = question.answerC
                radioGroup.clearCheck()
            } else {
                for (i in 0 until 15) {
                    if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                        userScore++
                    }
                }
                var activity: AppCompatActivity = context as AppCompatActivity
                val fragment = QuizResultFragment()
                val bundle = Bundle()
                bundle.putInt("correctAnswerCount", userScore)
                bundle.putInt("emptyAnswerCount", emptyAnswerCounter)
                for (quizElement in quiz) {
                    questions.add(quizElement.question)
                }
                bundle.putStringArrayList("questions", questions)
                bundle.putStringArrayList("userAnswers", userAnswers)
                bundle.putStringArrayList("correctAnswers", correctAnswers)
                fragment.setArguments(bundle)
                activity!!.supportFragmentManager.beginTransaction()
                    .replace(R.id.mainLayout, fragment).addToBackStack(null).commit()
            }
        }

        buttonHome.setOnClickListener { view ->
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout, CourseFragment()).addToBackStack(null).commit()
        }
    }
}
