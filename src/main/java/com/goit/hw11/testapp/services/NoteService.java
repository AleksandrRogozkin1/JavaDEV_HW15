package com.goit.hw11.testapp.services;

import com.goit.hw11.testapp.entity.Note;
import com.goit.hw11.testapp.repository.NoteRepository;
import com.goit.hw11.testapp.services.exception.NoteNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Slf4j
@Service
public class NoteService {

    private final NoteRepository noteRepository;

    @Autowired
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }


    public List<Note> getAll() {
        return noteRepository.findAll();
    }

    public Note addNote(Note note) {
        return noteRepository.save(note);
    }


    public Note getById(long id) throws NoteNotFoundException {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            return optionalNote.get();
        } else {
            throw new NoteNotFoundException(id);
        }
    }

    public void updateNote(Note note) throws NoteNotFoundException {
        Note ee = getById(note.getId());
        ee.setTitle(note.getTitle());
        ee.setContent(note.getContent());
        noteRepository.save(ee);
    }

    public void deleteById(Long id) throws NoteNotFoundException {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            noteRepository.deleteById(id);
        } else {
            throw new NoteNotFoundException(id);
        }

    }
}
