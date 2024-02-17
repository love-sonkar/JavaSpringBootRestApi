package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.Notes;
import com.crudapp.lovesonkar.model.Users;
import com.crudapp.lovesonkar.repository.NotesRepo;
import com.crudapp.lovesonkar.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})
public class NotesController {

    @Autowired
    private NotesRepo notesRepo;

    @Autowired
    private UsersRepo user;

    @PostMapping("/addnotes/{username}")
    String newNotes(@RequestBody Notes note, @PathVariable String username) {
        Notes resNote = notesRepo.save(note);
        Users userRes = user.findByUsername(username);
        userRes.setNotes(resNote);
        user.save(userRes);
        return "Notes Added";
    }

    @GetMapping("/allnotes")
    ArrayList<Notes> getAllNotes() {
        return (ArrayList<Notes>) notesRepo.findAll();
    }

    @DeleteMapping("/deletenotes/{id}")
    String deleteUser(@PathVariable Long id) {
        if (!notesRepo.existsById(id)) {
            return "Notes not found";
        }
        notesRepo.deleteById(id);
        return "Notes Deleted";
    }

    @GetMapping("/notes/{id}")
    Notes getSingleNotes(@PathVariable Long id) {
        if (!notesRepo.existsById(id)) {
            return null;
        }
        return notesRepo.findById(id).get();
    }

    @PutMapping("/notes/{id}")
    public void updateNotes(@RequestBody Notes note, @PathVariable Long id) {
        Notes nn = notesRepo.findById(id).get();
        nn.setNotesItem(note.getNotesItem());
        notesRepo.save(nn);
    }


}
