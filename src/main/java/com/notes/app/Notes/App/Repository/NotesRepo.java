package com.notes.app.Notes.App.Repository;

import com.notes.app.Notes.App.Models.Notes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotesRepo extends JpaRepository<Notes, Long> {
}
