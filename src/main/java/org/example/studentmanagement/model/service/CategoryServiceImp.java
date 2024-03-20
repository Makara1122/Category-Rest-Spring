package org.example.studentmanagement.model.service;

import lombok.AllArgsConstructor;
import org.example.studentmanagement.dto.CategoryRequest;
import org.example.studentmanagement.dto.CategoryRespon;
import org.example.studentmanagement.model.Category;
import org.example.studentmanagement.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService{
    private final CategoryRepository categoryRepository;
    @Override
    public List<CategoryRespon> getAllCategories() {
        return categoryRepository.getAllCategories().stream().map(this::convertToCategoryRespon).toList();
    }
    @Override
    public CategoryRespon createCategory(CategoryRequest request) {
         Category category = Category.builder()
                        .id(request.id())
                        .title(request.title())
                        .description(request.description()).build();
        categoryRepository.getAllCategories().add(category);
        return convertToCategoryRespon(category);
    }

    @Override
    public CategoryRespon convertToCategoryRespon(Category category) {
        return CategoryRespon.builder()
                .id(category.getId())
                .title(category.getTitle())
                .description(category.getDescription())
                .build();
    }

    @Override
    public CategoryRespon searchCategory(int id) {
        Category category = categoryRepository.getAllCategories().stream().filter(category1 -> category1.getId() == id).findFirst().orElseThrow(()->new RuntimeException("Category not found"));
        return convertToCategoryRespon(category);
    }

    @Override
    public List<CategoryRespon> searchCategoryByName(String name) {
        return categoryRepository.getAllCategories().stream().filter(category1 -> category1.getTitle().toLowerCase().trim().contains(name.toLowerCase().trim())).map(this::convertToCategoryRespon).toList();
}

    @Override
    public CategoryRespon editCategory(int id, CategoryRequest request) {
       return categoryRepository.getAllCategories().stream().filter(category -> category.getId() == id).findFirst().map(category -> {
          category.setId(request.id());
          category.setTitle(request.title());
          category.setDescription(request.description());
           return  convertToCategoryRespon(category);
       }).orElseThrow(()->new RuntimeException("Category not found"));
    }

    @Override
    public CategoryRespon deleteCategory(int id) {
        CategoryRespon categoryRespon = categoryRepository.getAllCategories().stream().filter(category -> category.getId() == id).findFirst().map(category -> {
           return  convertToCategoryRespon(category);


       }).orElseThrow(()->new RuntimeException("Category not found"));
        categoryRepository.getAllCategories().removeIf(category -> category.getId() == id);

   return  categoryRespon;

}}