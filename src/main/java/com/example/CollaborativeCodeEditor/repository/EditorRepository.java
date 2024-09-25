package com.example.CollaborativeCodeEditor.repository;

import com.example.CollaborativeCodeEditor.model.users.editor.Editor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EditorRepository extends JpaRepository<Editor, Long> {
    Editor findByEmail(String email);
}
