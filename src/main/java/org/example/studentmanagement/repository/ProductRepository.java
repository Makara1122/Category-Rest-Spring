package org.example.studentmanagement.repository;

import lombok.Builder;
import lombok.Getter;
import org.example.studentmanagement.dto.ProductRequest;
import org.example.studentmanagement.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Getter
@Repository
@Builder
public class ProductRepository {
    private static List<Product> allProducts = new ArrayList<>(List.of(

            Product.builder().
                    price(1).
                    title("product1").
                    description("description1").
                    imageUrl("imageUrl1").
                    build(),
            Product.builder().
                    price(2).
                    title("product2").
                    description("description2").
                    imageUrl("imageUrl2").
                    build(),
            Product.builder().
                    price(3).
                    title("product3").
                    description("description3").
                    imageUrl("imageUrl3").
                    build()


    ));

    public static List<Product> getAllProducts() {
        return allProducts;
    }

    public static void addProduct(ProductRequest productRequest) {
        Product product = Product.builder().
                id(productRequest.id()).
                price(productRequest.price()).
                title(productRequest.title()).
                description(productRequest.description()).
                imageUrl(productRequest.imageUrl()).
                build();
        allProducts.add(product);
    }


}
