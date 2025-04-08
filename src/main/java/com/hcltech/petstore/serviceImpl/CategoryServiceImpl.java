package com.hcltech.petstore.serviceImpl;

import com.hcltech.petstore.dto.CategoryDTO;
import com.hcltech.petstore.mapper.EntityDtoMapper;
import com.hcltech.petstore.model.Category;
import com.hcltech.petstore.repository.CategoryRepository;
import com.hcltech.petstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private EntityDtoMapper mapper;

    @Override
    public CategoryDTO createCategory(CategoryDTO dto) {
        Category category = new Category();
        category.setCategoryName(dto.getCategoryName());
        return mapper.toCategoryDTO(categoryRepository.save(category));
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return categoryRepository.findAll().stream().map(mapper::toCategoryDTO).toList();
    }

    @Override
    public CategoryDTO getCategoryById(Long id) {
        return categoryRepository.findById(id).map(mapper::toCategoryDTO)
                .orElseThrow(() -> new RuntimeException("Category not found"));
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
