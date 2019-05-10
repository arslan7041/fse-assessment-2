package com.demo.assessment2.servicetests;

import com.demo.assessment2.models.Product;
import com.demo.assessment2.repositories.ProductRepository;
import com.demo.assessment2.services.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    private ProductService productService;

    @Before
    public void setUp() {
        this.productService = new ProductService(productRepository);
    }

    @Test
    public void saveProduct_savesTheProduct() {
        //arrange
        Product product = new Product("dresses", "gucci", "yellow", 2272.0);

        //act
        productService.save(product);

        //assert
        verify(productRepository, times(1)).save(product);
    }

    @Test
    public void filterProductsByColor_returnsProductsWithThatColor() {
        String color = "black";
        //act
        productService.filterByPrice(color);
        //assert
        verify(productRepository, times(1)).findByColor(color);
    }
    @Test
    public void filterProductsByBrand_returnsProductsWithThatBrand() {
        String brand = "gucci";
        //act
        productService.filterByBrand(brand);
        //assert
        verify(productRepository, times(1)).findByBrand(brand);
    }

    @Test
    public void filterProductsByPrice_returnsProductsWithThatPrice() {
        String price = "1650.0";
        //act
        productService.filterByPrice(price);
        //assert
        verify(productRepository, times(1)).findByPrice(Double.valueOf(price).doubleValue());
    }

}
