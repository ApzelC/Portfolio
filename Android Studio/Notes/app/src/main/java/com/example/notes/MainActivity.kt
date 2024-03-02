package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.notes.adapter.CustomAdapter
import com.example.notes.databinding.ActivityMainBinding
import com.example.notes.model.Note
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        addNote()
        recieveNotes()
    }

    fun addNote() {
        binding.btnAdd.setOnClickListener{
            val intent = Intent(this, AddNoteActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        recieveNotes()
    }

    private fun recieveNotes() {
        val sharedPref = getSharedPreferences("notes", MODE_PRIVATE)
        val notes = sharedPref.all
        val gson = Gson()
        val noteList = mutableListOf<Note>()

        if(notes.isEmpty()){
            binding.tvEmpty.visibility = View.VISIBLE
        }
        else{
            binding.tvEmpty.visibility = View.GONE
            for (note in notes) {
                val noteJson = note.value.toString()
                val noteObj = gson.fromJson(noteJson, Note::class.java)
                noteList.add(noteObj)
            }
            //use layout_notes
            val adapter = CustomAdapter(this@MainActivity, R.layout.layout_notes, noteList)
            binding.lvNotes.adapter = adapter

            binding.lvNotes.setOnItemClickListener { parent, view, position, id ->
                val intent = Intent(this, NoteActivity::class.java)
                val title = noteList[position].title
                val content = noteList[position].content
                intent.putExtra("noteTitle", title)
                intent.putExtra("noteContent", content)
                startActivity(intent)
            }
        }
    }
}