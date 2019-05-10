package com.demo.assessment2.repositories;

import com.demo.assessment2.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByBrand();
    List<Product> findByColor();
    List<Product> findByPrice();
}
