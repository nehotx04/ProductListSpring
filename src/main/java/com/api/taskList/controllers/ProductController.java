package com.api.taskList.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.taskList.models.User;
import com.api.taskList.models.Product;
import com.api.taskList.repositories.ProductRepository;
import com.api.taskList.repositories.UserRepository;
import com.api.taskList.requests.ProductRequest;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private UserRepository userRepository;

    //Post
    @PostMapping()
    public String createProduct(@RequestBody ProductRequest request){
        User user =  userRepository.findById(request.getUserId()).orElse(null);
        if(user != null){
            Product newProduct = new Product();
            newProduct.setName(request.getName());
            newProduct.setDescription(request.getDescription());
            newProduct.setUser(user);

            productRepository.save(newProduct);
            return "Product created successfully";
        }else{
            return "User not found";
        }
    }

    //Get
    @GetMapping
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        Optional<Product> productOptional = productRepository.findById(id);
        return productOptional.get();
    }

    //Put
    @PutMapping("/edit/{id}")
    public String editProduct(@PathVariable Long id,@RequestBody ProductRequest request){
        Optional<Product> optionalProduct = productRepository.findById(id);
        
        User user =  userRepository.findById(request.getUserId()).orElse(null);
        if(user != null){
            optionalProduct.ifPresent(product -> {
                request.setId(id);
                product.setName(request.getName());
                product.setDescription(request.getDescription());
                product.setUser(user);
                productRepository.save(product);
            });
            return "Product Updated successfully";

        }else{
            return "Error User or Product not found";
        }
    }

    //Delete
    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product != null) {
            productRepository.deleteById(id);
            return "Product deleted successfully";
        }else{
            return "Product not found";
        }
    }


}
