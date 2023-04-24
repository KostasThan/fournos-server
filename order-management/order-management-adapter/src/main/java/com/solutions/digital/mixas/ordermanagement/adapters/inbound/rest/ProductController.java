package com.solutions.digital.mixas.ordermanagement.adapters.inbound.rest;

import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductSearchCriteriaDomain;
import com.solutions.digital.mixas.ordermanagement.core.service.product.ProductService;
import com.solutions.digital.mixas.ordermanagement.adapters.mappers.product.ProductMapper;
import com.solutions.digital.mixas.ordermanagement.rest.api.ProductApi;
import com.solutions.digital.mixas.ordermanagement.rest.dto.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
public class ProductController implements ProductApi {

    private final ProductService productService;

    private final ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @Override
    public ResponseEntity<List<Product>> findByCriteria(Long id, String name, Double price, Double minimumPrice,
                                                        Double maximumPrice,
                                                        Set<String> categoryName, Set<String> categoryDescription) {
        ProductSearchCriteriaDomain criteria = ProductSearchCriteriaDomain.builder()
                .id(id)
                .name(name)
                .price(price)
                .minimumPrice(minimumPrice)
                .maximumPrice(maximumPrice)
                .categoryName(categoryName)
                .categoryDescription(categoryDescription)
                .build();

        List<Product> products = productMapper.domainToDto(productService.findByCriteria(criteria));
        return ResponseEntity.ok(products);
    }
}
