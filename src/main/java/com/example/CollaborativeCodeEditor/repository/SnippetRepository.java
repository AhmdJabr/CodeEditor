package com.example.CollaborativeCodeEditor.repository;

import com.example.CollaborativeCodeEditor.model.component.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SnippetRepository extends JpaRepository<Snippet, Long> {
}
