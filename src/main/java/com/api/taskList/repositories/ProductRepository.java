package com.api.taskList.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.taskList.models.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{
    
}
