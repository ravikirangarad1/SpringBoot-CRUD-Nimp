package com.nimap_info.crud.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nimap_info.crud.entity.Category;
import com.nimap_info.crud.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public Page<Category> getAllCategories(Pageable pageable) {
		return categoryRepository.findAll(pageable);
	}

	public Optional<Category> getCategoryById(Long id) {
		return categoryRepository.findById(id);
	}

	public Category createCategory(Category category) {
		return categoryRepository.save(category);
	}

	public Category updateCategory(Long id, Category categoryDetails) {
		return categoryRepository.findById(id).map(category -> {
			category.setName(categoryDetails.getName());
			return categoryRepository.save(category);
		}).orElseThrow(() -> new RuntimeException("Category not found with id " + id));
	}

	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

}
