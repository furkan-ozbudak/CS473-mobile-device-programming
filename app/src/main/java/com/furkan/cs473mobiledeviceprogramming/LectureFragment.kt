package com.furkan.cs473mobiledeviceprogramming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

/**
 * A simple [Fragment] subclass.
 */
class LectureFragment : Fragment() {
    var lectures = ArrayList<Lecture>()
    var r1: RecyclerView? = null
    var madr: LectureRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lectures.add(Lecture("Lesson-1-Introduction", "lecture1.pdf"))
        lectures.add(Lecture("Lesson-2-Kotlin Fundamentals", "lecture2.pdf"))
        lectures.add(Lecture("Lesson-3-Creating First App", "lecture3.pdf"))
        lectures.add(Lecture("Lesson-4-Views, Layouts, Resources and Lifecycle", "lecture4.pdf"))
        lectures.add(Lecture("Lesson-5-Activities, Intents", "lecture5.pdf"))
        lectures.add(Lecture("Lesson-6-User Input Controls, Day1", "lecture6.pdf"))
        lectures.add(Lecture("Lesson-7-User Input Controls, Day2", "lecture7.pdf"))
        lectures.add(Lecture("Lesson-8-Menus, Tabs, Fragments, Day1", "lecture8.pdf"))
        lectures.add(Lecture("Lesson-9-Menus, Tabs, Fragments, Day2", "lecture9.pdf"))
        lectures.add(Lecture("Lesson-10-Shared Preferences, Web view", "lecture10.pdf"))
        lectures.add(Lecture("Lesson-11-Multimedia", "lecture11.pdf"))
        lectures.add(Lecture("Lesson-12-SQLite", "lecture12.pdf"))
        lectures.add(Lecture("Lesson-13-Sensors", "lecture13.pdf"))
        lectures.add(Lecture("Lesson-14-Localization", "lecture14.pdf"))
        lectures.add(Lecture("Lesson-15-Publish APK", "lecture15.pdf"))

        val view = inflater.inflate(R.layout.fragment_assignment, container, false)
        r1 = view.findViewById(R.id.rv) as RecyclerView
        madr = LectureRVAdapter(context!!, lectures)
        r1?.layoutManager = LinearLayoutManager(context)
        r1?.adapter = madr

        return view
    }

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

    }
}
