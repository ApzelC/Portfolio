package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notes.databinding.ActivityAddNoteBinding
import com.example.notes.model.Note
import com.google.gson.Gson

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        saveNote()
        returnToMain()
    }

    private fun saveNote() {
        binding.btnSave.setOnClickListener{
            val title = binding.edtNoteTitle.text.toString()
            val content = binding.edtNote.text.toString()

            if (title.isEmpty() || content.isEmpty()) {
                Toast.makeText(this, "Favor de asignar un titulo y contenido a la nota", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            else{
                val note = Note(
                    title = title,
                    content = content
                )

                val gson = Gson()
                val noteJson = gson.toJson(note)

                val sharedPref = getSharedPreferences("notes", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putString(note.title, noteJson)
                editor.apply()

                val intent = Intent(this, MainActivity::class.java)
                val flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            }
        }
    }

    private fun returnToMain() {
        binding.imgReturn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}