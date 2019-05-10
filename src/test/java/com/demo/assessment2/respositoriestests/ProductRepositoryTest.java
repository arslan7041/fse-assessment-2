package com.demo.assessment2.respositoriestests;

import com.demo.assessment2.models.Product;
import com.demo.assessment2.repositories.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProductRepositoryTest {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void repoSavesInDB() throws Exception {
        Product product = new Product(1, "dresses", "gucci", "yellow", 2272.0);

        Integer id = testEntityManager.persistAndGetId(product, Integer.class);
        Product foundProduct = productRepository.findById(id).orElse(null);
        assertThat(foundProduct.getCategory()).isEqualTo(product.getCategory());
    }

    @Test
    public void filterProductsByColor_returnsProductsWithThatColor(){
        String color="black";

        int size = productRepository.findByColor(color).size();
        assertThat(size==2);

    }
    @Test
    public void filterProductsByBrand_returnsProductsWithThatBrand(){
        String brand = "gucci";

        int size = productRepository.findByBrand(brand).size();
        assertThat(size==2);

    }

    @Test
    public void filterProductsByPrice_returnsProductsWithThatPrice() {
        String price = "1650.0";

        int size = productRepository.findByPrice(Double.valueOf(price).doubleValue()).size();
        assertThat(size==1);


    }

}
