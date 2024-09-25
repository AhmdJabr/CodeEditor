package com.example.CodeEditor.services;

import com.example.CodeEditor.model.users.editor.Editor;
import com.example.CodeEditor.repository.EditorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EditorService {
    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private AuthenticationManager manager;

    public List<Editor> getAllEditors() {
        return editorRepository.findAll();
    }

    public Editor getEditorById(Long id) {
        return editorRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No editor found with id: " + id)
        );
    }

    public Editor addEditor(Editor editor) {
        return editorRepository.save(editor);
    }

    public Editor updateEditor(Long id, Editor updatedEditor) {
        return editorRepository.findById(id).map(editor -> {
            editor.setName(updatedEditor.getName());
            editor.setPassword(updatedEditor.getPassword());
            return editorRepository.save(editor);
        }).orElseThrow(() -> new NoSuchElementException("Admin with ID " + id + " not found"));

    }

    public boolean deleteEditor(Long id) {
        if (editorRepository.existsById(id)) {
            editorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean authenticate(Editor editor){
        Authentication auth = manager.authenticate(
                new UsernamePasswordAuthenticationToken(editor.getEmail(), editor.getPassword())
        );

        return auth.isAuthenticated();
    }
}