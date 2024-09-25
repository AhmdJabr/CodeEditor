package com.example.CollaborativeCodeEditor.security;

import com.example.CollaborativeCodeEditor.model.users.editor.Editor;
import com.example.CollaborativeCodeEditor.model.users.editor.EditorDetails;
import com.example.CollaborativeCodeEditor.repository.EditorRepository;
import com.example.CollaborativeCodeEditor.services.EditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class EntityDetailsService implements UserDetailsService {
    @Autowired
    private EditorRepository editorRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Editor editor = editorRepository.findByEmail(username);
        if (editor == null) {
            System.out.println("Editor not found");
            throw new UsernameNotFoundException(username);
        }
        System.out.println(editor);
        return new EditorDetails(editor);
    }
}