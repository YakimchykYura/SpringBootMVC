package com.example.demo.NoteService;

import com.example.demo.Entity.Note;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class NoteService {
    private static List<Note> notes = new ArrayList<>();

    public void addNote (Note note) {
        if (notes.size() >= 1) {
            note.setId(generatorId());
            notes.add(note);
        } else {
            note.setId(1L);
            notes.add(note);
        }
    }
    public void updateNote(Note note) {
        Note ee = getById(note.getId());
        ee.setTitle(note.getTitle());
        ee.setContent(note.getContent());
    }
    public Note getById (Long id) {
        Iterator<Note> iterator = notes.iterator();
        while (iterator.hasNext()) {
            Note note = iterator.next();
            if (note.getId() == id) {
                return note;
            }
        }
        return null;
    }

    public void deleteNote(Long id) {
        notes.remove(getById(id));
    }
    public List<Note> getAllNotes() {
        return notes;
    }
    private long generatorId() {
        Note note = notes.get(notes.size() - 1);
        long nextId = note.getId() + 1;
        return nextId;
    }
}
