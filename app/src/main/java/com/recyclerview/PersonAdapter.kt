package com.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recyclerview.databinding.PersonViewBinding

class PersonAdapter(val people : List<Person>): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_view, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(people[position])

    }

    override fun getItemCount(): Int = people.size



    class ViewHolder(view: View): RecyclerView.ViewHolder(view){

        private val binding = PersonViewBinding.bind(view)

        fun bind(person : Person){

            binding.email.text = person.email
            binding.tlf.text = person.tlf
            binding.name.text = person.nombre

            Glide.with(binding.image).load(person.imagenUrl).into(binding.image)

        }


    }

}