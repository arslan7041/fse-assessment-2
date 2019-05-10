package com.demo.assessment2.controllers;

import com.demo.assessment2.models.Product;
import com.demo.assessment2.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/products/filter/{brand}")
    public List<Product> filterByBrand(@PathVariable String brand){
        return productService.filterByBrand(brand);
    }
}
