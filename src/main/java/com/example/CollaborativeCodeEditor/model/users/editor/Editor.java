package com.example.CollaborativeCodeEditor.model.users.editor;

import com.example.CollaborativeCodeEditor.model.users.Client;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Editor extends Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    public Editor(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
