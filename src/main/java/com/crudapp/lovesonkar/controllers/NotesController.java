package com.crudapp.lovesonkar.controllers;

import com.crudapp.lovesonkar.model.Notes;
import com.crudapp.lovesonkar.repository.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:5173/"})
public class NotesController {

    @Autowired
    private NotesRepo notesRepo;

    @PostMapping("/addnotes")
    Notes newNotes(@RequestBody Notes newNotes) {
        return notesRepo.save(newNotes);
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
    public void updateNotes(@RequestBody Notes note,@PathVariable Long id){
        Notes nn =  notesRepo.findById(id).get();
        nn.setNotesItem(note.getNotesItem());
        notesRepo.save(nn);
    }


}
