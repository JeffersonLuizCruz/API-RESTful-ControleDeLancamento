package com.lacamento.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping
	public List<Category> findAll(){
		return categoryRepository.findAll();
		/*
		 * Depreciado
		 * return !category.isEmpty() ? ResponseEntity.ok(category) : ResponseEntity.noContent().build();
		*/
	}
}
