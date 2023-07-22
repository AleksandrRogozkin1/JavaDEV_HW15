package com.goit.hw11.testapp.controllers;

import com.goit.hw11.testapp.Services.NoteService;
import com.goit.hw11.testapp.entity.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        ModelAndView result = new ModelAndView("/second/list");
        result.addObject("notes",noteService.getAll());
      return result;
    }
    @PostMapping("/create")
    public ModelAndView createNotes( @RequestParam(value="title")  String title,
                                     @RequestParam(value="content") String content) {
        Note note=new Note();
        note.setTitle(title);
        note.setContent(content);
        noteService.addNote(note);

        return allNotes();
    }

    @PostMapping("/update")
    public ModelAndView updateNotes(@RequestParam(value="id") long id,
                                    @RequestParam(value="title") String title,
                                     @RequestParam(value="content") String content)  {
        Note note = new Note();
        note.setId(id);
        note.setTitle(title);
        note.setContent(content);
        noteService.updateNote(note);
        return allNotes();
    }
    @PostMapping("/delete")
    public ModelAndView updateNotes( @RequestParam(value="id") long id)  {
        noteService.deleteById(id);
        return allNotes();
    }


}
