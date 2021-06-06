package com.wiseman.paul.androidroomdatabase.fragment.person

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.wiseman.paul.androidroomdatabase.R
import com.wiseman.paul.androidroomdatabase.model.Address
import com.wiseman.paul.androidroomdatabase.model.Person
import com.wiseman.paul.androidroomdatabase.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.fragment_person.*

class PersonFragment : Fragment() {
    val adapter by lazy { PersonAdapter() }
    private lateinit var myViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_person, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        person_recyclerView.adapter = adapter
        person_recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val address = Address("sangotedo", 10)
        val person = Person(0, "john", "Peter",25, address)
        myViewModel.insertPerson(person)
        myViewModel.readPerson.observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }
}