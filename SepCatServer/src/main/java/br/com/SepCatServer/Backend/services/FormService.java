package br.com.SepCatServer.Backend.services;

import br.com.SepCatServer.Backend.entities.Form;
import br.com.SepCatServer.Backend.repositories.FormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormService {

    @Autowired
    private FormRepository repository;

    public List<Form> findAll() {
        return repository.findAll();
    }

    public Form findById(Long id) {
       Optional<Form> obj =  repository.findById(id);
       return obj.get();
    }
}
