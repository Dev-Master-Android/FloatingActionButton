package com.example.floatingactionbutton

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelProvider
import com.example.floatingactionbutton.ui.presentation.NoteApp
import com.example.floatingactionbutton.ui.theme.FloatingActionButtonTheme
import com.example.floatingactionbutton.viewModel.NotePreferences
import com.example.floatingactionbutton.viewModel.NoteViewModel
import com.example.floatingactionbutton.viewModel.NoteViewModelFactory

class MainActivity : ComponentActivity() {
    private lateinit var noteViewModel: NoteViewModel
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val notePrefs = NotePreferences(this)
        noteViewModel = ViewModelProvider(
            this,
            NoteViewModelFactory(notePrefs)
        )[NoteViewModel::class.java]
        setContent {
            FloatingActionButtonTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NoteApp(noteViewModel)
                }
            }
        }
    }
}
