package org.example.studentmanagement.controller;

import lombok.AllArgsConstructor;

import org.example.studentmanagement.dto.ProductRequest;
import org.example.studentmanagement.model.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class ProductController {
    private final ProductService productService;
    @GetMapping("/products")
    public Map<String, Object> getAllProducts(){
        HashMap<String,Object> response = new HashMap<>();
        response.put("payload",productService.getAllProduct());
        response.put("message","Retrieved Data Successfully!");
        response.put("status", HttpStatus.OK.value());
        return response;
    }

    @PostMapping("/new-product")
    public Map<String, Object> createNewProduct(@RequestBody ProductRequest productRequest){
        HashMap<String , Object> response = new HashMap<>();
            response.put("payload",productService.createProduct(productRequest));
            response.put("message", "Product created successfully !");
            response.put("status", HttpStatus.CREATED.value());
        return response;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Map<String, Object> getProductById(@PathVariable("id") int id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", productService.findeProductById(id));
        response.put("message", "Product Found !!");
        response.put("status", HttpStatus.FOUND.value());
        return response;
    }

    @GetMapping("/search-product")
    public Map<String, Object> searchProduct(@RequestParam(defaultValue = "") String productName){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", productService.searchProduct(productName));
        response.put("message", "Product Found !!");
        response.put("status", HttpStatus.FOUND.value());
        return response;
    }
    @PatchMapping("/update-product/{id}")
    public Map<String, Object> updateProduct(@PathVariable("id") int id, @RequestBody ProductRequest productRequest){
        HashMap<String, Object> response = new HashMap<>();
        System.out.println(productService.updateProduct(productRequest,id));
        response.put("payload", productService.updateProduct(productRequest,id));
        response.put("message", "Product Updated !!");
        response.put("status", HttpStatus.OK.value());
        return response;
    }

    @DeleteMapping("/delete-product/{id}")
    public Map<String,Object> deleteProduct(@PathVariable("id") int id){
        HashMap<String, Object> response = new HashMap<>();
        response.put("payload", productService.deleteProduct(id));
        response.put("message", "Product Deleted !!");
        response.put("status", HttpStatus.OK.value());
        return response;
    }


}
