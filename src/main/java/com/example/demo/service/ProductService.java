package com.example.demo.service;

import com.example.demo.entity.Product;

import java.util.List;

public interface ProductService {
     Product saveProduct(Product product);

     List<Product> saveMultipleProduct(List<Product> product);

     List<Product> getAllProducts();

    Product findProduct(Integer id);

    Product findProductByName(String productName);

    String deleteById(Integer id);

    Product updateProduct(Product product);

}
