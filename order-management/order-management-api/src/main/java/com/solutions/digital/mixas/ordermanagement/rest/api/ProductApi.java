package com.solutions.digital.mixas.ordermanagement.rest.api;

import com.solutions.digital.mixas.ordermanagement.rest.dto.Product;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Tag(name = "Products")
public interface ProductApi {

    String BASE_URL = "products";

    @Operation(summary = "Finds all Products according to the given query parameters.")
    @GetMapping(value = BASE_URL)
    ResponseEntity<List<Product>> findByCriteria(
            @Parameter(in = ParameterIn.QUERY, description = "The id of the product.")
            @RequestParam(required = false) Long id,

            @Parameter(in = ParameterIn.QUERY, description = "The name of the product.")
            @RequestParam(required = false) String name,

            @Parameter(in = ParameterIn.QUERY, description = "The price of the product.")
            @RequestParam(required = false) Double price,

            @Parameter(in = ParameterIn.QUERY, description = "The minimum price(including) the product must have.")
            @RequestParam(required = false) Double minimumPrice,

            @Parameter(in = ParameterIn.QUERY, description = "The maximum price(including) the product must have.")
            @RequestParam(required = false) Double maximumPrice,

            @Parameter(in = ParameterIn.QUERY, description = "The category name of the product.")
            @RequestParam(required = false) Set<String> categoryName,

            @Parameter(in = ParameterIn.QUERY, description = "The category description of the product.")
            @RequestParam(required = false) Set<String> categoryPrice
    );
}
