package com.notes.app.Notes.App.Validations;

import com.notes.app.Notes.App.Models.Notes;
import lombok.SneakyThrows;

public class Validator {

    @SneakyThrows
    public static void ValidateNotesCreationRequest(Notes note) {
        if (note.getTitle() == null || note.getTitle().trim().isEmpty()) {
            throw new Exception("Title is required");
        } else if (note.getTitle().length() > 100) {
            throw new Exception("Title is too long");
        } else if (note.getTitle().length() < 5) {
            throw new Exception("Title is too short");
        } else if (note.getContent() == null || note.getContent().trim().isEmpty()) {
            throw new Exception("Content is required");
        } else if (note.getContent().length() > 1000) {
            throw new Exception("Content is too long");
        }
    }
}
