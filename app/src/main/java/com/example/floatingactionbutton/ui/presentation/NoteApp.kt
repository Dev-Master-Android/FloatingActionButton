package com.example.floatingactionbutton.ui.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.floatingactionbutton.viewModel.NoteViewModel


@Composable
fun NoteApp(viewModel: NoteViewModel) {
    var text by remember  { mutableStateOf("") }

    Column(modifier = Modifier.padding(36.dp)) {
        Text(text = "Заметки", style = MaterialTheme.typography.bodyLarge)

        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Введите текст заметки") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        FloatingActionButton(onClick = {
            if (text.isNotEmpty()) {
                viewModel.addNote(text)
                text = ""
            }
        }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Добавить заметку")
        }

        LazyColumn {
            items(viewModel.notes) { note ->
                NoteItem(note = note, onDelete = { viewModel.deleteNote(note) })
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun NoteAppPreview() {
    //NoteApp(viewModel = com.example.floatingactionbutton.viewModel.NoteViewModel())
}