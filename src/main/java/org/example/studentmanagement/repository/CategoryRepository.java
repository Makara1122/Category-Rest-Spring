package org.example.studentmanagement.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.example.studentmanagement.model.Category;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Builder
@Repository
@RequiredArgsConstructor
@AllArgsConstructor
public class CategoryRepository {
    List<Category> categories = new ArrayList<>(List.of(
            Category.builder().
                     id(1).
                     title("Electronics").
                     description("Electronic items").
                     build(),
            Category.builder().
                     id(2).
                     title("Clothing").
                     description("Clothing items").
                     build(),
            Category.builder().
                     id(3).
                     title("Books").
                     description("Books items").
                     build()
    ));

    public List<Category> getAllCategories(){
        return categories;
    }

}
