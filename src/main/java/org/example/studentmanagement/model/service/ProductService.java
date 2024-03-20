package org.example.studentmanagement.model.service;

import org.example.studentmanagement.dto.ProductRequest;
import org.example.studentmanagement.dto.ProductResponse;

import java.util.List;
import java.util.Objects;

public interface ProductService {

    List<ProductResponse> getAllProduct();
    ProductResponse createProduct(ProductRequest product);
    ProductResponse deleteProduct(int productId);
    ProductResponse updateProduct(ProductRequest product,int id);
    ProductResponse findeProductById(int productId);
    List<ProductResponse> searchProduct(String productName);

}
