package com.lacamento.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.lacamento.model.Category;

@SpringBootTest
public class CategoryTest {
	
	@Autowired CategoryRepository categoryRepository;
	
	@Test
	public void saveTest() {
		Category category = new Category(null, "Roupas", null);
		categoryRepository.save(category);
	}
	
	

}
