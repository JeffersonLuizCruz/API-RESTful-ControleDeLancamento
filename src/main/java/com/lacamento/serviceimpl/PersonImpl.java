package com.lacamento.serviceimpl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;

import com.lacamento.model.Person;
import com.lacamento.repository.PersonRepository;
import com.lacamento.serviceinterfaces.PersonService;

public class PersonImpl implements PersonService{

	@Autowired private PersonRepository personRepository;
	
	@Override
	public Person save(Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person update(Long id, Person person) {
		Person isPerson = isEmptyPerson(id);
		
		BeanUtils.copyProperties(person, isPerson, "id");
		
		return personRepository.save(person);
	}

	@Override
	public Person getById(Long id) {
		Person person = isEmptyPerson(id);
		return person;
	}

	@Override
	public void delete(Long id) {
		personRepository.deleteById(id);
		
	}
	
private Person isEmptyPerson(Long id) {
		
		Optional<Person> exceptionEmptyPerson = personRepository.findById(id);
		
		if(null == exceptionEmptyPerson) {
			throw new EmptyResultDataAccessException(1);
		}
		
		return exceptionEmptyPerson.get();
		
	}


}
