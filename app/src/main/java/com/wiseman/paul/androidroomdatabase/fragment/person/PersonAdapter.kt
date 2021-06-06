package com.wiseman.paul.androidroomdatabase.fragment.person

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.wiseman.paul.androidroomdatabase.R
import com.wiseman.paul.androidroomdatabase.fragment.list.ListFragmentDirections
import com.wiseman.paul.androidroomdatabase.model.Person
import com.wiseman.paul.androidroomdatabase.model.User
import kotlinx.android.synthetic.main.custom_row.view.*
import kotlinx.android.synthetic.main.custom_row.view.firstName_txt
import kotlinx.android.synthetic.main.custom_row.view.id_txt
import kotlinx.android.synthetic.main.custom_row.view.lastName
import kotlinx.android.synthetic.main.person_row_layout.view.*

class PersonAdapter:RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    private var personList = emptyList<Person>()
    class PersonViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        return PersonViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.person_row_layout, parent, false))
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val currentItem = personList[position]
        holder.itemView.id_txt.text = currentItem.id.toString()
        holder.itemView.tv_firstName.text = currentItem.firstName
        holder.itemView.tv_lastName.text = currentItem.lastName
        holder.itemView.tv_streetName.text = currentItem.address.streetName
        holder.itemView.tv_streetNumber.text = currentItem.address.streetNumber.toString() }

    override fun getItemCount() = personList.size

    fun setData(person: List<Person>){
        this.personList = person
        notifyDataSetChanged()
    }
}

