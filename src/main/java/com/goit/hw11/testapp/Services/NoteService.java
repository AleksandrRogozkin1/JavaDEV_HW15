package com.goit.hw11.testapp.Services;

import com.goit.hw11.testapp.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private static final List<Note> notes = new ArrayList<>();

    public List<Note> getAll() {
        return this.notes;
    }

    public Note addNote(Note note) {
        if (notes.size() >= 1) {
            note.setId(getLastId() + 1);
            notes.add(note);
        } else {
            note.setId(1);
            notes.add(note);
        }
        System.out.println("Note has been added!");
        return note;
    }

    private static long getLastId() {
        Note note = notes.get(notes.size() - 1);
        return note.getId();
    }


    public Note getById(long id) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId() == id) {
                System.out.println("Note has been found!");
                return note;
            }
        }
        return null;
    }

    public void updateNote(Note note) {
        Note ee=getById(note.getId());
        ee.setTitle(note.getTitle());
        ee.setContent(note.getContent());

    }


    public void deleteById(Long id) {
        notes.remove(getById(id));
        System.out.println("Note has been deleted!");
    }


}
