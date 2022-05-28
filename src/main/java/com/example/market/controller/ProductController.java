package com.example.market.controller;

import com.example.market.dto.response.GetAllProductsResponse;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * The type Product controller.
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {


    private final ProductService productService;

    /**
     * Instantiates a new Product controller.
     *
     * @param productService the product service
     */
    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    /**
     * Find all get all product response.
     *
     * @return the get all products response
     */
    @GetMapping("/get-all")
    public GetAllProductsResponse findAll() {
        return productService.findAll();
    }

    /**
     * Find by id get all product response.
     *
     * @param id the id
     * @return the get all products response
     */
    @GetMapping("/get-by-id")
    public GetAllProductsResponse findById(@Valid @RequestParam(value = "id") Long id) {
        return productService.findById(id);
    }
}