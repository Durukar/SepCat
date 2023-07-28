package br.com.SepCatServer.Backend.controllers;

import br.com.SepCatServer.Backend.entities.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<Users> findAll() {
        Users u = new Users(1L, "Lucas", "teste@teste.com" , "9999");
        return ResponseEntity.ok().body(u);
    }
}
