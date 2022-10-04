package com.recyclerview

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.recyclerview.databinding.PersonViewBinding

class PersonAdapter(val people : List<Person>, val listener: (Person) ->Unit): RecyclerView.Adapter<PersonAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Guardamos la vista inflada en una variable y la devolvemos
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_view, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        //llamamos a la funcion bind creada abajo con la persona
        holder.bind(people[position])

        //Guardamos a la persona en una variable
        val person = people[position]

        //Ponemos un escuchador de eventos para cuando se haga un click
        // en contacto llamamos a la funcion que se pasa por parametro a esta misma clase
        holder.itemView.setOnClickListener {
            listener(person)

        }


    }

    //Devuelve el tamaño de la lista pasada por parametro
    override fun getItemCount(): Int = people.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        //Obtenemos los items de la vista en la variable
        private val binding = PersonViewBinding.bind(view)

        //Esta funcion cambia todos los valores de texto de las
        // etiquetas recogidas y cambia tmb la imagen con Glide
        fun bind(person : Person){

            binding.email.text = person.email
            binding.tlf.text = person.tlf
            binding.name.text = person.nombre

            Glide.with(binding.image).load(person.imagenUrl).into(binding.image)

        }


    }

}