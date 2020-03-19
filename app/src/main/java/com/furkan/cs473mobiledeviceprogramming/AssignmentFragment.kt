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
class AssignmentFragment : Fragment() {
    var assignments = ArrayList<Assignment>()
    var r1: RecyclerView? = null
    var madr: RecyclerViewAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        assignments.add(Assignment("Assignment-1", "assignment1.pdf"))
        assignments.add(Assignment("Assignment-2", "assignment2.pdf"))
        assignments.add(Assignment("Assignment-3", "assignment3.pdf"))
        assignments.add(Assignment("Assignment-4", "assignment4.pdf"))
        assignments.add(Assignment("Assignment-5", "assignment5.pdf"))
        assignments.add(Assignment("Assignment-6", "assignment6.pdf"))

        val view = inflater.inflate(R.layout.fragment_assignment, container, false)
        r1 = view.findViewById(R.id.rv) as RecyclerView
        madr = RecyclerViewAdapter(context!!, assignments)
        r1?.layoutManager = LinearLayoutManager(context)
        r1?.adapter = madr

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


}
