package org.example.studentmanagement.dto;

import lombok.Builder;

@Builder
public record CategoryRespon(int id, String title,String description) {
}
