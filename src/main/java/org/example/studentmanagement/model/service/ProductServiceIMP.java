package org.example.studentmanagement.model.service;


import org.example.studentmanagement.dto.ProductRequest;
import org.example.studentmanagement.dto.ProductResponse;
import org.example.studentmanagement.model.Product;
import org.example.studentmanagement.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class ProductServiceIMP implements ProductService{

    @Override
    public List<ProductResponse> getAllProduct() {
       return   ProductRepository.getAllProducts().stream().map(pro->{
           System.out.println(pro.getId());
            return ProductResponse.builder().
                    id(pro.getId()).
                    imageUrl(pro.getImageUrl()).
                    title(pro.getTitle()).
                    price(pro.getPrice()).
                    description(pro.getDescription()).
                    build();
        }).toList();


    }


    @Override
    public ProductResponse createProduct(ProductRequest product) {
        ProductRepository.addProduct(product);

        return ProductResponse.builder().
                id(product.id()).
                imageUrl(product.imageUrl()).
                title(product.title()).
                price(product.price()).
                description(product.description()).
                build();

    }

    @Override
    public ProductResponse deleteProduct(int productId) {
        System.out.println( " Product delete ID: " + productId);


        Product product = ProductRepository.getAllProducts().stream().filter(pro->pro.getId() == productId).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
        ProductRepository.getAllProducts().removeIf(product1 -> product1.getId() == productId);        return ProductResponse.builder()
                .id(product.getId())
                .imageUrl(product.getImageUrl())
                .title(product.getTitle())
                .price(product.getPrice())
                .description(product.getDescription())
                .build();

    }

    @Override
    public ProductResponse updateProduct(ProductRequest product,int id) {
        System.out.println(id + " Product update ID: " + product.id());
        return ProductRepository.getAllProducts().stream().filter(pro->pro.getId() == id).map(pro->{
            pro.setId(product.id());
            pro.setImageUrl(product.imageUrl());
            pro.setTitle(product.title());
            pro.setPrice(product.price());
            pro.setDescription(product.description());

            return ProductResponse.builder().
                    id(pro.getId()).
                    imageUrl(pro.getImageUrl()).
                    title(pro.getTitle()).
                    price(pro.getPrice()).
                    description(pro.getDescription()).
                    build();
        }).findFirst().orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public ProductResponse findeProductById(int productId) {
        Product product = ProductRepository.getAllProducts().stream().filter(pro->pro.getId() == productId).findFirst().orElse(null);

        assert product != null;
        return ProductResponse.builder().
                id(product.getId()).
                imageUrl(product.getImageUrl()).
                title(product.getTitle()).
                price(product.getPrice()).
                description(product.getDescription()).
                build();
    }

    @Override
    public List<ProductResponse> searchProduct(String productName) {
        return ProductRepository.getAllProducts().stream().filter(pro->pro.getTitle().toLowerCase().contains(productName.toLowerCase())).map(pro-> ProductResponse.builder().
                id(pro.getId()).
                imageUrl(pro.getImageUrl()).
                title(pro.getTitle()).
                price(pro.getPrice()).
                description(pro.getDescription()).
                build()).toList();
    }
}
