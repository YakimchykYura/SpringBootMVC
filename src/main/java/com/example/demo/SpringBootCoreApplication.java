package com.example.demo;

import com.example.demo.Entity.Note;
import com.example.demo.NoteService.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class SpringBootCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCoreApplication.class, args);
		Note note = new Note();
		NoteService service = new NoteService();
		note.setContent("Yura");
		note.setTitle("Yakimchyk");
		service.addNote(note);
	}

}
