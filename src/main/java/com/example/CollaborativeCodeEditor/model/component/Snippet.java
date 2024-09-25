package com.example.CollaborativeCodeEditor.model.component;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Snippet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String path;
    private String extension;
    private String content;

    public Snippet(String name, String path, String extension, String content) {
        this.name = name;
        this.path = path;
        this.extension = extension;
        this.content = content;
    }
}
