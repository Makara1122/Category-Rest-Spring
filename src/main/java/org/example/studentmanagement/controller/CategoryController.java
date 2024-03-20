package org.example.studentmanagement.controller;

import lombok.AllArgsConstructor;
import org.example.studentmanagement.dto.CategoryRequest;
import org.example.studentmanagement.model.service.CategoryService;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;


@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryServicer;
   private static Map<String, Object> response (Object data,String message,HttpStatus status){
       Map<String,Object> response = new HashMap<>();
       response.put("payload",data);
       response.put("message",message);
       response.put("status",status.value());
       return response;

   }

    @GetMapping("/get-all")
    public Map<String , Object> getAllCategories(){
    return  response(categoryServicer.getAllCategories(),"success retrieve all CATEGORIES ",HttpStatus.OK);
    }

    @PostMapping("/create-category")
    public Map<String,Object> createCategory(@RequestBody CategoryRequest categoryRequest){
        return response(categoryServicer.createCategory(categoryRequest),"success created category successfully !! ",HttpStatus.CREATED);
    }
    @GetMapping("/search-category/{id}")
    public Map<String, Object> searchCategory(@PathVariable("id") int id) {
        return response(categoryServicer.searchCategory(id), "Category has been found ", HttpStatus.OK);
    }
    @GetMapping("/search-by-name")
    public Map<String, Object> searchCategoryByName(@RequestParam(defaultValue ="") String name){
       return response(categoryServicer.searchCategoryByName(name),"Category has been found ",HttpStatus.FOUND);
    }
    @PatchMapping("/edit-category/{id}")
    public Map<String,Object> editCategory(@PathVariable("id")int id,@RequestBody CategoryRequest categoryRequest){
    return response(categoryServicer.editCategory(id,categoryRequest),"Category has been updated Successfully !! ",HttpStatus.CREATED);
    }
    @PutMapping("/delete-category/{id}")
    public Map<String,Object> deleteCategory(@PathVariable("id")int id){
       return  response(categoryServicer.deleteCategory(id),"Category has been deleted Successfully !! ",HttpStatus.FOUND);
    }

}


