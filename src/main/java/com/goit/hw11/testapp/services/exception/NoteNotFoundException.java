package com.goit.hw11.testapp.services.exception;

public class NoteNotFoundException extends Exception {

    private static final String NOTE_NOT_FOUND_EXCEPTION_TEXT = "Note with id = %s not found.";


    public NoteNotFoundException(Long noteId) {
        super(String.format(NOTE_NOT_FOUND_EXCEPTION_TEXT, noteId));
    }
}
