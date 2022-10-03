package com.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val urlPerfilH = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.freepik.es%2Ffotos%2Fhombre-perfil&psig=AOvVaw0cmaZ0pDdTmbF2Lg3pAdfS&ust=1664892890370000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCIDeiL6fxPoCFQAAAAAdAAAAABAD"
    val urlPerfilM = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dzoom.org.es%2Ffoto-perfil-redes-sociales%2F&psig=AOvVaw0cmaZ0pDdTmbF2Lg3pAdfS&ust=1664892890370000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCIDeiL6fxPoCFQAAAAAdAAAAABAI"
    val list = listOf<Person>(Person("Fernando", "625245368", "nandimarquez31@gmail.com", urlPerfilH),
                             Person("Pedro", "625145251", "pedrojurado@gmail.com", urlPerfilH),
                             Person("Lucia", "625154514" , "lucia@gmail.com", urlPerfilM),
                             Person("Diana", "64851224" , "dianasitamorenita@gmail.com", urlPerfilM),
                             Person("Pepe", "632155214" , "pepitogrillo@gmail.com", urlPerfilH)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater).apply {

            setContentView(root)

            recycler.adapter = PersonAdapter(list)

        }


    }
}

