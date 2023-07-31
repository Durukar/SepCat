package br.com.SepCatServer.Backend.controllers;

import br.com.SepCatServer.Backend.entities.Form;
import br.com.SepCatServer.Backend.services.FormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class FormController {

    @Autowired
    private FormService service;

    @GetMapping(value = "/forms")
    public ResponseEntity<List<Form>> findAll() {
        List<Form> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/forms/{id}")
    public ResponseEntity<Form> findById(@PathVariable Long id) {
        Form obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
