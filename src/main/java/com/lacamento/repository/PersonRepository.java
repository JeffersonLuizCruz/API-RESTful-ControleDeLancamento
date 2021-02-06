package com.lacamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lacamento.model.Person;
import com.lacamento.repository.person.PersonRepositoryQuery;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>, PersonRepositoryQuery{

}
