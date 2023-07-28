package br.com.SepCatServer.Backend.services;

import br.com.SepCatServer.Backend.entities.Inssue;
import br.com.SepCatServer.Backend.repositories.InssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InssueService {

    @Autowired
    private InssueRepository repository;

    public List<Inssue> findAll() {
        return repository.findAll();
    }

    public Inssue findById(Long id) {
       Optional<Inssue> obj =  repository.findById(id);
       return obj.get();
    }
}
