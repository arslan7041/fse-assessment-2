package com.demo.assessment2.services;

import com.demo.assessment2.models.Product;
import com.demo.assessment2.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public void save(Product product) {
        productRepository.save(product);
    }

    public List<Product> filterByBrand(String brand){
        return productRepository.findByBrand(brand);
    }

    public List<Product> filterByColor(String color){
        return productRepository.findByColor(color);
    }

    public List<Product> filterByPrice(String price){
        double doublePrice = Double.valueOf(price).doubleValue();
        return productRepository.findByPrice(doublePrice);
    }






}
