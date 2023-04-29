package com.example.demo.service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product saveProduct(Product product) {
        log.info("Save Product Invoked");
        return productRepository.saveAndFlush(product);
    }

    public List<Product> saveMultipleProduct(List<Product> product) {
        log.info("Save Multiple Product Invoked");
        return productRepository.saveAllAndFlush(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product findProduct(Integer id) {
        log.info("Save Product Invoked");
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    public Product findProductByName(String productName) {
        log.info("Save Product Invoked");
        return productRepository.findByName(productName).orElseThrow(() -> new RuntimeException("Product Not Found"));
    }

    public String deleteById(Integer id) {
        productRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElseThrow(() -> new RuntimeException("Product Not Found"));
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.saveAndFlush(existingProduct);
    }
}
