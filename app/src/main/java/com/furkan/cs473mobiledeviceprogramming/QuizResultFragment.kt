package com.furkan.cs473mobiledeviceprogramming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.fragment_quiz_result.*

/**
 * A simple [Fragment] subclass.
 */
class QuizResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        var correctAnswerCount = bundle!!.getInt("correctAnswerCount",-1000)
        var emptyAnswerCount = bundle.getInt("emptyAnswerCount",-1000)
        var wrongAnswerCount = 15 - correctAnswerCount - emptyAnswerCount
        if(wrongAnswerCount <= 0) {
            wrongAnswerCount = 0
        }
        var correctAnswerOutput = "Correct Answers : " + correctAnswerCount.toString()
        var wrongAnswerOutput = "Wrong Answers : " + wrongAnswerCount.toString()
        var emptyAnswerOutput = "Empty Answers: " + emptyAnswerCount.toString()
        var scoreOutput = "Your score is: " + correctAnswerCount.toString() + "/15"

        txtCorrectAnswers.text = correctAnswerOutput
        txtWrongAnswers.text = wrongAnswerOutput
        txtEmptyAnswers.text = emptyAnswerOutput
        txtScore.text = scoreOutput

        buttonResultAnalysis.setOnClickListener {
            val bundle = this.arguments
            var questions = bundle!!.getStringArrayList("questions")
            var userAnswers = bundle!!.getStringArrayList("userAnswers")
            var correctAnswers = bundle!!.getStringArrayList("correctAnswers")


            var activity: AppCompatActivity = context as AppCompatActivity
            val fragment = QuizResultAnalysisFragment()
            val bundleToSend = Bundle()
            bundleToSend.putStringArrayList("questions", questions)
            bundleToSend.putStringArrayList("userAnswers", userAnswers)
            bundleToSend.putStringArrayList("correctAnswers", correctAnswers)
            fragment.setArguments(bundleToSend)
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout, fragment).addToBackStack(null).commit()
        }

        buttonTryAgain.setOnClickListener {
            activity!!.supportFragmentManager.beginTransaction()
                .replace(R.id.mainLayout, QuizFragment()).commit()
        }

    }

}
