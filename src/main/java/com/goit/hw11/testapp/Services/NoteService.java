package com.goit.hw11.testapp.Services;

import com.goit.hw11.testapp.entity.Note;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class NoteService {
    private static final List<Note> notes = new ArrayList<>();

    public Note addNote(Note note) {
        long id = note.getId();
        if (notes.contains(id)) {
            throw new IllegalArgumentException("Note already created");
        } else {
            id = getLastId() + 1;
            note.setId(id);
            notes.add(note);
        }
        System.out.println("Note has been added!");
        return note;
    }

    private Long getLastId() {
        return notes.stream().max(Comparator.comparing(Note::getId)).get().getId();
    }


    public Note getById(long id) {
        if (!notes.contains(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
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
    }
//    public Optional<Note> getById(long id) {
//        if (!notes.contains(id)) {
//            throw new IllegalArgumentException("Note not found");
//        } else {
//           return notes.stream().filter(note -> note.getId()== id).findFirst();
//
//        }
//    }


    public void updateNote(Note note) {
        Note oldNote = getById(note.getId());
        oldNote.setContent(note.getContent());
        oldNote.setTitle(note.getTitle());
        System.out.println("Note has been updated!");
    }
//    public void updateNote(Note note) {
//        Optional<Note> noteOptional = this.notes.stream().filter(n -> n.getId() == note.getId()).findFirst();
//        if (noteOptional.isPresent()) {
//            this.notes.remove(noteOptional.get());
//            this.notes.add(note);
//        }
//    }


    public void deleteById(Long id) {
        if (!notes.contains(id)) {
            throw new IllegalArgumentException("Note not found");
        } else {
            notes.remove(getById(id));
        }

        System.out.println("Note has been deleted!");
    }


    public List<Note> listAll() {
        return notes;
    }


}
