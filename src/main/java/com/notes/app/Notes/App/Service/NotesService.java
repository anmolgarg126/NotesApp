package com.notes.app.Notes.App.Service;

import com.notes.app.Notes.App.Models.Notes;
import com.notes.app.Notes.App.Models.NotesCreationResponse;

import java.util.List;

public interface NotesService {
    NotesCreationResponse createNote(Notes note);

    Notes getNoteById(Long id);

    List<Notes> getAllNotes();
}
