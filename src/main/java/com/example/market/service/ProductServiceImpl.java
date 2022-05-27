package com.example.market.service;

import com.example.market.dto.response.GetAllProductsResponse;
import com.example.market.entity.Product;
import com.example.market.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Product service.
 */
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    /**
     * Instantiates a new Product service.
     *
     * @param productRepository the product repository
     */
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GetAllProductsResponse findAll() {
        List<Product> products = productRepository.findAll();
        if (products.isEmpty())
            return GetAllProductsResponse.builder()
                    .message("No products")
                    .messageCode("GA-00001")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        return GetAllProductsResponse.builder()
                .products(products)
                .message("Successfully fetched all products")
                .messageCode("GA-00002")
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public GetAllProductsResponse findById(Long id) {
        Product product = productRepository.findByProductId(id);
        if (product == null)
            return GetAllProductsResponse.builder()
                    .message("Product not found")
                    .messageCode("GA-00001")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        return GetAllProductsResponse.builder()
                .products(List.of(product))
                .message("Successfully fetched product by id")
                .messageCode("GA-00002")
                .status(HttpStatus.OK.value())
                .build();
    }
}