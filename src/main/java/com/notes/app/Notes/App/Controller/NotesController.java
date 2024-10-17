package com.notes.app.Notes.App.Controller;

import com.notes.app.Notes.App.Models.Notes;
import com.notes.app.Notes.App.Models.NotesCreationResponse;
import com.notes.app.Notes.App.Models.Response;
import com.notes.app.Notes.App.Service.NotesService;
import com.notes.app.Notes.App.Validations.Validator;
import jakarta.annotation.Nullable;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {

    private final NotesService notesService;

    @PostMapping("/add")
    public ResponseEntity<Response<NotesCreationResponse>> addNewNote(@RequestBody Notes note) {
        Validator.ValidateNotesCreationRequest(note);
        NotesCreationResponse response = notesService.createNote(note);
        return ResponseEntity.ok(new Response<>("added", 200, response));
    }

    @GetMapping("/byId")
    public ResponseEntity<Response<Notes>> addNewNote(@RequestParam @Nullable Long id) {
        Notes response = notesService.getNoteById(id);
        return ResponseEntity.ok(new Response<>(null, 200, response));
    }

    @GetMapping("/all")
    public ResponseEntity<Response<List<Notes>>> addNewNote() {
        List<Notes> response = notesService.getAllNotes();
        return ResponseEntity.ok(new Response<>(null, 200, response));
    }

}
