package com.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.recyclerview.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    //Crea la constante para recoger del intent a la persona
    companion object{

        const val SELECTED_PERSON = "personaSeleccionada"

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //crea el bindig guardando el  layout inflado
        val binding = ActivityDetailBinding.inflate(layoutInflater)
        //Muestra la vista
        setContentView(binding.root)

        //Recoge la persona que pasa person adapter cuando clicamos en un contacto
        val person = intent.getParcelableExtra<Person>(SELECTED_PERSON)

        //Si persona no es nula entra en la condicion y le cambia el nombre y la imagen al textView y a la imagen del layout
        if(person != null) {
            binding.textView.text = person.nombre
            Glide.with(binding.imageView).load(person.imagenUrl).into(binding.imageView)
        }


    }
}