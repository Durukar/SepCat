package br.com.SepCatServer.Backend.controllers;

import br.com.SepCatServer.Backend.entities.Inssue;
import br.com.SepCatServer.Backend.services.InssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class InssueController {

    @Autowired
    private InssueService service;

    @GetMapping(value = "/inssues")
    public ResponseEntity<List<Inssue>> findAll() {
        List<Inssue> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/inssues/{id}")
    public ResponseEntity<Inssue> findById(@PathVariable Long id) {
        Inssue obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
