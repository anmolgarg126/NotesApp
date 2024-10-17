package com.notes.app.Notes.App.Service.Impl;

import com.notes.app.Notes.App.Models.Notes;
import com.notes.app.Notes.App.Models.NotesCreationResponse;
import com.notes.app.Notes.App.Repository.NotesRepo;
import com.notes.app.Notes.App.Service.NotesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NotesServiceImpl implements NotesService {

    private final NotesRepo notesRepo;

    @Override
    public NotesCreationResponse createNote(Notes note) {
        Notes updated = notesRepo.save(note);
        NotesCreationResponse response = new NotesCreationResponse();
        response.setId(updated.getId());
        response.setMessage("Note created successfully");
        return response;
    }

    @Override
    public Notes getNoteById(Long id) {
        return notesRepo.findById(id).orElse(null);
    }

    @Override
    public List<Notes> getAllNotes() {
        return notesRepo.findAll();
    }
}
