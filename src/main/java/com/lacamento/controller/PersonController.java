package com.lacamento.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacamento.event.Event;
import com.lacamento.model.Person;
import com.lacamento.repository.PersonRepository;

@RestController
@RequestMapping(value = "persons")
public class PersonController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Autowired private PersonRepository personRepository;
	@Autowired private ApplicationEventPublisher publisher;
	
	@PostMapping
	public ResponseEntity<Person> save(@RequestBody Person person, HttpServletResponse response) {
		Person savePerson = personRepository.save(person);
		publisher.publishEvent(new Event(this, response, savePerson.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(savePerson);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Person> getById(@PathVariable Long id) {
		Optional<Person> personId = personRepository.findById(id);
		return personId != null ? ResponseEntity.of(personId) : ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> findAll(){
		List<Person> persons = personRepository.findAll();
		return ResponseEntity.ok(persons);
	}

}
