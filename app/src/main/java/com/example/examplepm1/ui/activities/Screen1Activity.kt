package com.example.examplepm1.ui.activities

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examplepm1.R
import com.example.examplepm1.data.repositories.SimpleItemRepository
import com.example.examplepm1.adapter.SimpleAdapter

class Screen1Activity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var backButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        recyclerView = findViewById(R.id.simple_recycler_view)
        backButton = findViewById(R.id.back_button)

        // Setea la configuración del RecyclerView, en este caso la posición de los items
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Obtiene la lista de items
        val itemList = SimpleItemRepository.getItems()

        // Crea y setea el adapter
        val adapter = SimpleAdapter(itemList)
        recyclerView.adapter = adapter

        // Setea el botón de regreso
        backButton.setOnClickListener {
            finish()
        }
    }
}
