package com.example.pais

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    // Declaración de variables miembro
    private lateinit var textView: TextView
    private lateinit var listView: ListView
    private val countries = arrayOf(
        "Argentina", "Bolivia", "Brasil", "Chile", "Colombia", "Ecuador", "Guyana",
        "Paraguay", "Perú", "Surinam", "Uruguay", "Venezuela"
    )
    private val populations = arrayOf(
        "45,376,763", "11,428,245", "211,049,527", "18,952,038", "50,372,424", "17,377,361",
        "782,766", "7,152,703", "32,971,854", "581,372", "3,474,182", "28,515,829"
    )
    //Método OnCreate
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Inicialización de variables
        textView = findViewById(R.id.tv1)
        listView = findViewById(R.id.list1)
        // Creación del adaptador y asignación al ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, countries)
        listView.adapter = adapter
        // Manejador del evento de clic en un elemento del ListView
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedCountry = parent.getItemAtPosition(position).toString()
            val population = populations[position]
            textView.text = "Población de $selectedCountry: $population"
        }
    }
}
