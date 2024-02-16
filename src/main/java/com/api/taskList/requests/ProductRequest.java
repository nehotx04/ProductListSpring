package com.api.taskList.requests;

import lombok.Data;

@Data
public class ProductRequest {
    private Long id;
    private String name;
    private String description;
    private Long userId;

}
