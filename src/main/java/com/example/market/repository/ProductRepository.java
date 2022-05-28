package com.example.market.repository;

import com.example.market.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * The interface Product repository.
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Find by product name list.
     *
     * @param name the name
     * @return the list
     */
    List<Product> findByProductName(String name);

    /**
     * Find by product id product.
     *
     * @param id the id
     * @return the product
     */
    Product findByProductId(Long id);

    /**
     * Find by category list.
     *
     * @param category the category
     * @return the list
     */
    List<Product> findByCategory(String category);
}
