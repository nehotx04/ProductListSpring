package com.api.taskList.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import com.api.taskList.repositories.ProductRepository;
import com.api.taskList.models.Product;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    //Get All Products
    public List<Product> getAllProducts(){ return productRepository.findAll(); }

    //Get one product by ID
    public  Optional<Product> getProductById(Long id){ return productRepository.findById(id); }

    //Create a product
    public Product createProduct(Product product){ return productRepository.save(product); }

    //Update product
    public Product updateProduct(Product product){ return productRepository.save(product); }

    //Delete product
    public void deleteProductById(Long id){ productRepository.deleteById(id); }

}
