package br.com.comerce.SepComerce.services;

import br.com.comerce.SepComerce.exception.ResourceNotFoundException;
import br.com.comerce.SepComerce.model.Person;
import br.com.comerce.SepComerce.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<Person> findAll() {
        return repository.findAll();
    }

    public Person findById(Long id) {

        logger.info("Finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Lucas");
        person.setLastName("Davila");
        person.setAddress("Brasilia - DF");
        person.setGender("MALE");
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    private Person mockPerson(int i) {
        logger.info("Finding one person");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Person name " + i);
        person.setLastName("Last name " + i);
        person.setAddress("Some address in Brasil " + i);
        person.setGender("MALE");
        return person;
    }

    public Person create(Person person) {
        logger.info("Creating onse person!");
        return repository.save(person);
    }

    public Person update(Person person) {
        logger.info("Update one person!");
        var entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return repository.save(person);
    }

    public void delete(String id) {
        logger.info("Deleting one person!");
    }
}
