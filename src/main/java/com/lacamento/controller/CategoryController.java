package com.lacamento.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacamento.event.Event;
import com.lacamento.model.Category;
import com.lacamento.repository.CategoryRepository;


@RestController
@RequestMapping(value = "categories")
public class CategoryController {
	
	@Autowired private CategoryRepository categoryRepository;
	@Autowired private ApplicationEventPublisher publisher;

	
	@PostMapping
	public ResponseEntity<Category> save(@RequestBody Category category, HttpServletResponse response) {
		Category saveCategory = categoryRepository.save(category);
		publisher.publishEvent(new Event(this, response, saveCategory.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(saveCategory);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Category>> getById(@PathVariable Long id){
		Optional<Category> result = categoryRepository.findById(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping
	public ResponseEntity<List<Category>> listAll(){
		List<Category> result = categoryRepository.findAll();
		return ResponseEntity.ok(result);
		/*
		 * Depreciado
		 * return !category.isEmpty() ? ResponseEntity.ok(category) : ResponseEntity.noContent().build();
		*/
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		categoryRepository.deleteById(id);
	}
}
