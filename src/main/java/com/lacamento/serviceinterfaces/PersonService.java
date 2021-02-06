package com.lacamento.serviceinterfaces;

import org.springframework.stereotype.Service;

import com.lacamento.model.Person;

@Service
public interface PersonService {
	
	public Person save(Person person);
	public Person update(Long id, Person person);
	public Person getById(Long id);
	//public Page<Person> listAll(PessoaFilter pessoaFilter, Pageable pageable);
	public void delete(Long id);
	

}
