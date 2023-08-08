package br.com.comerce.SepComerce.controller;

import br.com.comerce.SepComerce.model.Person;

import br.com.comerce.SepComerce.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    PersonService personService;

    @RequestMapping(value = "/all" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll() {
        return personService.findAll();
    }

    @RequestMapping(value="/{id}",
            method=RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable(value = "id") Long id) throws Exception{
        return personService.findById(id);
    }

    @RequestMapping(
            method=RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) throws Exception{
        return personService.create(person);
    }

    @RequestMapping(
            method=RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) throws Exception{
        return personService.update(person);
    }

    @RequestMapping(value="/{id}",
            method=RequestMethod.DELETE)
    public void delete(@PathVariable(value = "id") Long id) throws Exception{
        personService.delete(id);
    }
}
