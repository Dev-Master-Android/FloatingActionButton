package com.example.floatingactionbutton.viewModel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class NoteViewModel(private val notePrefs: NotePreferences) : ViewModel() {
    private val _notes = mutableStateListOf<String>()
    val notes: List<String> = _notes

    init {
        _notes.addAll(notePrefs.loadNotes())
    }

    fun addNote(note: String) {
        _notes.add(note)
        notePrefs.saveNotes(_notes)
    }

    fun deleteNote(note: String) {
        _notes.remove(note)
        notePrefs.saveNotes(_notes)
    }
}
