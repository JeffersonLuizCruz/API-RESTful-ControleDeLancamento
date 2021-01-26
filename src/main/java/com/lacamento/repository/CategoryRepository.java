package com.lacamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lacamento.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
