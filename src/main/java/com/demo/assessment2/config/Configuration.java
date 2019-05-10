package com.demo.assessment2.config;

import com.demo.assessment2.models.Product;
import com.demo.assessment2.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    CommandLineRunner runner(ProductService productService) {

        return args -> {

            // adding test data
            productService.save(new Product("dresses", "gucci", "yellow", 2272.0));
            productService.save(new Product("dresses", "gucci", "red", 1966.0));
            productService.save(new Product("dresses", "marni", "brown", 999.0));
            productService.save(new Product("dresses", "marni", "pink", 1129.0));
            productService.save(new Product("dresses", "bottega veneta", "black", 2200.0));
            productService.save(new Product("dresses", "prada", "black", 1650.0));
            productService.save(new Product("dresses", "victoria beckham", "blue", 927.0));
            productService.save(new Product("dresses", "celine", "beige", 1901.0));
            productService.save(new Product("dresses", "jil sander", "orange", 511.0));
        };
    }
}
