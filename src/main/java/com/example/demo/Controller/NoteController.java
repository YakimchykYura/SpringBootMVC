package com.example.demo.Controller;

import com.example.demo.Entity.Note;
import com.example.demo.NoteService.NoteService;

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
        result.addObject("notes",noteService.getAllNotes());
        return result;
    }

    @PostMapping("/create")
    public ModelAndView createNotes(@ModelAttribute Note note) {
        noteService.addNote(note);
        return allNotes();
    }


    @GetMapping("/update")
    public String updateNote(@RequestParam Long id, Model model) {
        model.addAttribute("note", noteService.getById(id));
        return "update";
    }

    @PostMapping("/update")
    public ModelAndView updateNotes(@RequestBody Note updatedNote)  {
        noteService.updateNote(updatedNote);
        return allNotes();
    }

    @PostMapping("/delete")
    public ModelAndView deleteNotes(@RequestParam long id)  {
        noteService.deleteNote(id);
        return allNotes();
    }
}
