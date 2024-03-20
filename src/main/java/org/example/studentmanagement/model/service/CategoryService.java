package org.example.studentmanagement.model.service;

import org.example.studentmanagement.dto.CategoryRequest;
import org.example.studentmanagement.dto.CategoryRespon;
import org.example.studentmanagement.model.Category;

import java.util.List;

public interface CategoryService {
    List<CategoryRespon> getAllCategories();
    CategoryRespon createCategory(CategoryRequest request);
    CategoryRespon convertToCategoryRespon(Category category);
    CategoryRespon searchCategory(int id);
    List<CategoryRespon> searchCategoryByName(String name);
    CategoryRespon editCategory(int id,CategoryRequest request);
    CategoryRespon deleteCategory(int id);

}
