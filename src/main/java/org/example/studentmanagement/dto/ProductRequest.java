package org.example.studentmanagement.dto;

import lombok.Data;


public record ProductRequest (int id,String title,String description,float price,String imageUrl) {

}
