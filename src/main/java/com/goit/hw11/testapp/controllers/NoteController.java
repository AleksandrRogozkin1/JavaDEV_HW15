package com.goit.hw11.testapp.controllers;


import com.goit.hw11.testapp.entity.Note;
import com.goit.hw11.testapp.services.NoteService;
import com.goit.hw11.testapp.services.exception.NoteNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/note")
public class NoteController {
    private final NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/list")
    public ModelAndView allNotes() {
        ModelAndView result = new ModelAndView("/list");
        result.addObject("notes", noteService.getAll());
        return result;
    }

    //
//    @PostMapping("/create")
//    public ModelAndView createNotes(@RequestParam(value="title")  String title,
//                                    @RequestParam(value="content") String content) {
//        Note note = new Note();
//        note.setTitle(title);
//        note.setContent(content);
//        noteService.addNote(note);
//        return allNotes();
//    }
    @PostMapping("/create")
    public ModelAndView createNotes(@ModelAttribute Note note) {
        noteService.addNote(note);
        return allNotes();
    }


    @GetMapping("/update")
    public String updateNote(@RequestParam(name = "id") Long id, Model model) {
        try {
            model.addAttribute("note", noteService.getById(id));
        } catch (NoteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return "update";
    }

    @PostMapping("/update")
    public ModelAndView updateNotes(@RequestBody Note updatedNote) {
        try {
            noteService.updateNote(updatedNote);
        } catch (NoteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return allNotes();
    }

    @PostMapping("/delete")
    public ModelAndView deleteNotes(@RequestParam(value = "id") long id) {
        try {
            noteService.deleteById(id);
        } catch (NoteNotFoundException e) {
            throw new RuntimeException(e);
        }
        return allNotes();
    }
}