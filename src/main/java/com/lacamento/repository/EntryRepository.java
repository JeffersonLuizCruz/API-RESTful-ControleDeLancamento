package com.lacamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lacamento.model.Entry;

@Repository
public interface EntryRepository extends JpaRepository<Entry, Long>{

}
