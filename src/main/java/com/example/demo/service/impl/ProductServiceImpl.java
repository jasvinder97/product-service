package com.example.demo.service.impl;

import com.example.demo.entity.Product;
import com.example.demo.exception.ProductException;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

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
        log.info("Get All Product Invoked");
        return productRepository.findAll();
    }

    public Product findProduct(Integer id) {
        log.info("find Product Invoked with id : {}", id);
        return productRepository.findById(id).orElseThrow(() -> new ProductException("Product Not Found"));
    }

    public Product findProductByName(String productName) {
        log.info("find Product Invoked with name : {}", productName);
        return productRepository.findByName(productName).orElseThrow(() -> new ProductException("Product Not Found"));
    }

    public String deleteById(Integer id) {
        log.info("Delete Product Invoked with id : {}", id);
        productRepository.deleteById(id);
        return "Deleted Successfully";
    }

    public Product updateProduct(Product product) {
        log.info("Update Product Invoked");
        Product existingProduct = productRepository.findById(product.getId()).orElseThrow(() -> new ProductException("Product Not Found"));
        existingProduct.setPrice(product.getPrice());
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        return productRepository.saveAndFlush(existingProduct);
    }
}
