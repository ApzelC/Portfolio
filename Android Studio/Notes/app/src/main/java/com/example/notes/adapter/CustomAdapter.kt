package com.example.notes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.notes.R
import com.example.notes.model.Note

class CustomAdapter(val context: Context, val layout: Int, val datos: List<Note>): BaseAdapter() {
    override fun getCount(): Int {
        return datos.size
    }

    override fun getItem(position: Int): Any {
        return datos[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    private val inflater: LayoutInflater =
        context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(layout, parent, false)

        val titleNote = view.findViewById<TextView>(R.id.tvTitleAdapter)
        val note  = getItem(position) as Note
        titleNote.text = note.title

        return view
    }
}






