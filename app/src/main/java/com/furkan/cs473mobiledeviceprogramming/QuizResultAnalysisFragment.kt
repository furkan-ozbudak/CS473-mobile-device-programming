package com.furkan.cs473mobiledeviceprogramming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_quiz_result_analysis.*

/**
 * A simple [Fragment] subclass.
 */
class QuizResultAnalysisFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz_result_analysis, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = this.arguments
        var questions = bundle!!.getStringArrayList("questions") as ArrayList<String>
        var userAnswers = bundle!!.getStringArrayList("userAnswers") as ArrayList<String>
        var correctAnswers = bundle!!.getStringArrayList("correctAnswers") as ArrayList<String>

        var output = "                  RESULT ANALYSIS\n\n"
        for (i in 0 until 15) {
            output += questions.get(i) + "\n\nYour Answer: " + userAnswers.get(i) + "\n\nCorrect Answer: " + correctAnswers.get(i) + "\n\n\n\n"
        }
        txtResultAnalysis.text = output
    }

}
