package com.api.taskList.requests;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String name;
    private String lastname;
    private String email;

}