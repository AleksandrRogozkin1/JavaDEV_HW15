package com.goit.hw11.testapp.Services;

import com.goit.hw11.testapp.entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NoteService {
    private static final List<Note> notes = new ArrayList<>();

    public List<Note> getAll() {
        return notes;
    }

    public Note addNote(Note note) {
        if (notes.size() >= 1) {
            note.setId(getLastId() + 1);
            notes.add(note);
        } else {
            note.setId(1L);
            notes.add(note);
        }
        log.info("Note has been added!");
        return note;
    }

    private long getLastId() {
        Note note = notes.get(notes.size() - 1);
        return note.getId();
    }

    public Note getById(long id) {
        for (Note note : notes) {
            if (note.getId() == id) {
                log.info("Note has been found!");
                return note;
            }
        }
        return null;
    }

    public void updateNote(Note note) {
        Note ee = getById(note.getId());
        ee.setTitle(note.getTitle());
        ee.setContent(note.getContent());
    }

    public void deleteById(Long id) {
        notes.remove(getById(id));
        log.info("Note has been deleted!");
    }
}
