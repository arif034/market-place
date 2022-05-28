package com.example.market.service;

import com.example.market.dto.request.AddProductRequest;
import com.example.market.dto.response.AddProductResponse;
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
                    .messageCode("FBI-00001")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        return GetAllProductsResponse.builder()
                .products(List.of(product))
                .message("Successfully fetched product by id")
                .messageCode("FBI-00002")
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public GetAllProductsResponse findByName(String name) {
        List<Product> products = productRepository.findByProductName(name);
        if (products == null || products.isEmpty())
            return GetAllProductsResponse.builder()
                    .message("Product not found by name")
                    .messageCode("FBN-00001")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        return GetAllProductsResponse.builder()
                .products(products)
                .message("Successfully fetched product by name")
                .messageCode("FBN-00002")
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public GetAllProductsResponse findByCategory(String category) {
        List<Product> products = productRepository.findByCategory(category);
        if (products == null || products.isEmpty())
            return GetAllProductsResponse.builder()
                    .message("Product not found by category")
                    .messageCode("FBC-00001")
                    .status(HttpStatus.NOT_FOUND.value())
                    .build();
        return GetAllProductsResponse.builder()
                .products(products)
                .message("Successfully fetched product by category")
                .messageCode("FBC-00002")
                .status(HttpStatus.OK.value())
                .build();
    }

    @Override
    public AddProductResponse addProduct(AddProductRequest addProductRequest) {
        Product product = Product.builder()
                .productName(addProductRequest.getProductName())
                .price(addProductRequest.getPrice())
                .category(addProductRequest.getCategory())
                .build();
        productRepository.save(product);
        if (product.getProductId() == null)
            return AddProductResponse.builder()
                    .message("Not able to add product")
                    .messageCode("AP-00001")
                    .status(HttpStatus.BAD_REQUEST.value())
                    .build();
        return AddProductResponse.builder()
                .productId(product.getProductId())
                .message("Successfully added product")
                .messageCode("AP-00002")
                .status(HttpStatus.OK.value())
                .build();
    }
}