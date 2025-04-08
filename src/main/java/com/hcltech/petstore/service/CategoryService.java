package com.hcltech.petstore.service;

import com.hcltech.petstore.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {

    CategoryDTO createCategory(CategoryDTO dto);
    List<CategoryDTO> getAllCategories();
    CategoryDTO getCategoryById(Long id);
    void deleteCategory(Long id);
}
