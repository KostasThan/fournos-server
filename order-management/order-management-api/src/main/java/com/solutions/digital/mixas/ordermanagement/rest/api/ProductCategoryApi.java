package com.solutions.digital.mixas.ordermanagement.rest.api;

import com.solutions.digital.mixas.ordermanagement.rest.dto.ProductCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Tag(name = "ProductCategories")
public interface ProductCategoryApi {

    String BASE_URL = "product-categories";

    @Operation(summary = "Finds all Product Categories according to the given query parameters.")
    @GetMapping(value = BASE_URL)
    ResponseEntity<List<ProductCategory>> findByCriteria(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String description
    );


    @Operation(summary = "Creates a new Product Category", description = "The `Product` name and description must be unique")
    @PostMapping(value = BASE_URL)
    ResponseEntity<ProductCategory> addProduct(
            @RequestBody ProductCategory productCategory);
}
