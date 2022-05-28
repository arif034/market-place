package com.example.market.service;

import com.example.market.dto.request.AddProductRequest;
import com.example.market.dto.response.AddProductResponse;
import com.example.market.dto.response.GetAllProductsResponse;

/**
 * The interface Product service.
 */
public interface ProductService {

    /**
     * Find all get all product response.
     *
     * @return the get all products response
     */
    GetAllProductsResponse findAll();

    /**
     * Find by id get all product response.
     *
     * @param id the id
     * @return the get all products response
     */
    GetAllProductsResponse findById(Long id);

    /**
     * Find by name get all product response.
     *
     * @param name the name
     * @return the get all products response
     */
    GetAllProductsResponse findByName(String name);

    /**
     * Find by category get all product response.
     *
     * @param category the category
     * @return the get all products response
     */
    GetAllProductsResponse findByCategory(String category);

    /**
     * Add product response.
     *
     * @param addProductRequest the add product request
     * @return the add product response
     */
    AddProductResponse addProduct(AddProductRequest addProductRequest);
}
