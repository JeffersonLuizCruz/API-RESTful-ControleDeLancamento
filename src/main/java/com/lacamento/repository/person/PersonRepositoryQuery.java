package com.lacamento.repository.person;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.lacamento.model.Person;
import com.lacamento.repository.filter.PersonFilter;

public interface PersonRepositoryQuery {

	public Page<Person> filterByPerson(PersonFilter personFilter, Pageable pageable);
}
