package com.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //Crea estas variables para las fotos de perfil de los hombre y mujeres(son fotos al azar)
    val urlPerfilH = "https://loremflickr.com/g/320/240/paris,dog"
    val urlPerfilM = "https://loremflickr.com/g/320/240/paris,dog"

    //Crea la lista con personas
    val list = listOf<Person>(Person("Fernando", "625245368", "nandimarquez31@gmail.com", urlPerfilH),
                             Person("Pedro", "625145251", "pedrojurado@gmail.com", urlPerfilH),
                             Person("Lucia", "625154514" , "lucia@gmail.com", "$urlPerfilM?lock=1"),
                             Person("Diana", "64851224" , "dianasitamorenita@gmail.com", urlPerfilM),
                             Person("Pepe", "632155214" , "pepitogrillo@gmail.com", urlPerfilH)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Crea el bindig guardando el  layout inflado
        val binding =ActivityMainBinding.inflate(layoutInflater).apply {

            //Muestra la vista
            setContentView(root)
        }
            //Asocia el adapter al recycler  y define la funcion que se le pasa por parametro a personAdapter
            //(que se llamara en el onBindViewHolder cuando se clicke sobre una persona)
            binding.recycler.adapter = PersonAdapter(list){ person->

                //Guarda en una variable el detailActivity de las personas
                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                //Envia la persona al Detail
                intent.putExtra(DetailActivity.SELECTED_PERSON, person)

                //Inicia la variable que iniciaba el detail de las personas
                startActivity(intent)

            }






    }
}

