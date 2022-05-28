package com.example.market.controller;

import com.example.market.dto.request.AddProductRequest;
import com.example.market.dto.response.AddProductResponse;
import com.example.market.dto.response.GetAllProductsResponse;
import com.example.market.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * The type Product controller.
 */
@RestController
@CrossOrigin(origins = "*")
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
     * Sets response header.
     *
     * @param response the response
     */
    @ModelAttribute
    public void setResponseHeader(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", "*");
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

    /**
     * Find by name get all product response.
     *
     * @param name the name
     * @return the get all products response
     */
    @GetMapping("/get-by-name")
    public GetAllProductsResponse findByName(@Valid @RequestParam(value = "name") String name) {
        return productService.findByName(name);
    }

    /**
     * Find by category get all product response.
     *
     * @param category the category
     * @return the get all products response
     */
    @GetMapping("/get-by-category")
    public GetAllProductsResponse findByCategory(@Valid @RequestParam(value = "category") String category) {
        return productService.findByCategory(category);
    }

    /**
     * Add product response.
     *
     * @param addProductRequest the add product request
     * @return the add product response
     */
    @PostMapping("add-product")
    public AddProductResponse addProduct(@Valid @RequestBody AddProductRequest addProductRequest, HttpServletResponse response)
    {
        response.setHeader("Access-Control-Allow-Origin", "*");
        return productService.addProduct(addProductRequest);
    }
}