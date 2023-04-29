package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/save")
    ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveProduct(product));
    }

    @PutMapping("/update")
    ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.updateProduct(product));
    }

    @PostMapping("/multiple/save")
    ResponseEntity<List<Product>> saveProducts(@RequestBody List<Product> product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.saveMultipleProduct(product));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteProducts(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productService.deleteById(id));
    }

    @GetMapping("/all")
    ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
    }

    @GetMapping("/search/{id}")
    ResponseEntity<Product> findById(@PathVariable Integer id) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProduct(id));
    }

    @GetMapping("/search")
    ResponseEntity<Product> findByProductName(@RequestParam String name) {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findProductByName(name));
    }
}
