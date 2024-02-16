package com.api.taskList.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="userId", referencedColumnName = "id")
    private User user;

    public Long getUserId() {
        if (user != null) {
            return user.getId();
        } else {
            return null;
        }
    }
    
    public void setUserId(Long userId) {
        if (user == null) {
            user = new User();
        }
        user.setId(userId);
    }
    
}
