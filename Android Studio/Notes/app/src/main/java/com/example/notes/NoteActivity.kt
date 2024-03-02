package com.example.notes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.notes.databinding.ActivityNoteBinding
import com.example.notes.model.Note

class NoteActivity : AppCompatActivity() {
    lateinit var binding: ActivityNoteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showNote()
        returnToMain()
        deleteNote()
    }

    private fun showNote() {
        val noteTitle = intent.getStringExtra("noteTitle")
        val content = intent.getStringExtra("noteContent")

        binding.tvTitleNote.text = noteTitle
        binding.tvNote.text = content
    }

    private fun returnToMain() {
        binding.btnReturn.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }

    private fun deleteNote() {
        binding.btnDelete.setOnClickListener{
            val noteTitle = intent.getStringExtra("noteTitle")
            val sharedPref = getSharedPreferences("notes", MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.remove(noteTitle)
            editor.apply()

            val intent = Intent(this, MainActivity::class.java)
            val flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
    }
}