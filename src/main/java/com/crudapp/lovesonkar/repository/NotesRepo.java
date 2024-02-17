package com.crudapp.lovesonkar.repository;

import com.crudapp.lovesonkar.model.Notes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotesRepo extends JpaRepository<Notes, Long> {
}
