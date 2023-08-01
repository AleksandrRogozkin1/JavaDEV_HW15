package com.goit.hw11.testapp.repository;

import com.goit.hw11.testapp.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {
}
