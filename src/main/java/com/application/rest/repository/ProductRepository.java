package com.application.rest.repository;

import com.application.rest.entities.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    // Usando QueryMethods de JPA
    List<Product> findProductByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);

    // Usando anotación Query con JPASQL
    //@Query("SELECT p FROM Product p WHERE p.price >= ?1 AND p.price <= ?2")
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN ?1 AND ?2")
    List<Product> findProductbyPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
}
