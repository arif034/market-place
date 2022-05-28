package com.example.market.service;

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
}
