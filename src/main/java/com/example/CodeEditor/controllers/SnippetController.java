package com.example.CodeEditor.controllers;

import com.example.CodeEditor.model.component.Snippet;
import com.example.CodeEditor.repository.SnippetRepository;
import com.example.CodeEditor.services.SnippetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/snippet")
public class SnippetController {
    @Autowired
    private SnippetService snippetService;
    @Autowired
    private SnippetRepository snippetRepository;

    @GetMapping("/get")
    public List<Snippet> getAllSnippets() {
        return snippetService.getAllSnippets();
    }

    @GetMapping("/get/{id}")
    public Snippet getSnippetById(@PathVariable Long id) {
        return snippetService.getSnippet(id);
    }

    @PostMapping("/add")
    public Snippet addSnippet(@RequestBody Snippet snippet) {
        return snippetService.addSnippet(snippet);
    }

    @PutMapping("/update/{id}")
    public Snippet updateSnippet(@PathVariable Long id, @RequestBody Snippet snippet) {
        return snippetService.updateSnippet(id, snippet);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSnippet(@PathVariable Long id) {
        if (snippetService.deleteSnippet(id)) {
            return "Snippet with id " + id + " was deleted";
        }
        return "Snippet with id " + id + " could not be deleted";
    }
}
