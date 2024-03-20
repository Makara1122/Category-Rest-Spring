package org.example.studentmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

// This will be used with database.

@Builder
@Data
@AllArgsConstructor
@RequiredArgsConstructor

public class Product {
    private int id;
    private String title;
    private String description;
    private float price;
    private String imageUrl;
}
