package com.recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val urlPerfilH = "https://loremflickr.com/g/320/240/paris,dog"
    val urlPerfilM = "https://loremflickr.com/g/320/240/paris,dog"
    val list = listOf<Person>(Person("Fernando", "625245368", "nandimarquez31@gmail.com", urlPerfilH),
                             Person("Pedro", "625145251", "pedrojurado@gmail.com", urlPerfilH),
                             Person("Lucia", "625154514" , "lucia@gmail.com", "$urlPerfilM?lock=1"),
                             Person("Diana", "64851224" , "dianasitamorenita@gmail.com", urlPerfilM),
                             Person("Pepe", "632155214" , "pepitogrillo@gmail.com", urlPerfilH)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =ActivityMainBinding.inflate(layoutInflater)

            setContentView(binding.root)

            binding.recycler.adapter = PersonAdapter(list){ person->

                val intent = Intent(this@MainActivity, DetailActivity::class.java)

                intent.putExtra(DetailActivity.SELECTED_PERSON, person)

                startActivity(intent)

            }






    }
}

