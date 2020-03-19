package com.furkan.cs473mobiledeviceprogramming

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CourseFragment(), "Course")
        adapter.addFragment(QuizFragment(), "Quiz")
        adapter.addFragment(AssignmentFragment(), "Assignment")
        adapter.addFragment(LectureFragment(), "Lecture")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}
