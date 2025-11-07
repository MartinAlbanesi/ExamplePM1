package com.example.examplepm1.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examplepm1.R
import com.example.examplepm1.data.models.Item

class SimpleAdapter(private val items: List<Item>) :
    RecyclerView.Adapter<SimpleAdapter.SimpleViewHolder>() {

    // Describe la vista de cada elemento y su contenido
    class SimpleViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.item_title)
        val descriptionTextView: TextView = view.findViewById(R.id.item_description)
    }

    // Se llama cuando el RecyclerView necesita un nuevo ViewHolder para representar un elemento.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sample_layout, parent, false)
        return SimpleViewHolder(view)
    }

    // Se llama cuando el RecyclerView necesita establecer los datos del elemento en la vista.
    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the contents of the view with it
        val item = items[position]
        holder.titleTextView.text = item.title
        holder.descriptionTextView.text = item.description
    }

    // Retorna el tamaño del conjunto de datos
    override fun getItemCount() = items.size
}
