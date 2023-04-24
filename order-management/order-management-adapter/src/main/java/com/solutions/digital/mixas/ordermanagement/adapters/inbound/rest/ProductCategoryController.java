package com.solutions.digital.mixas.ordermanagement.adapters.inbound.rest;

import com.solutions.digital.mixas.ordermanagement.adapters.mappers.productcategory.ProductCategoryMapper;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategoryDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategorySearchCriteriaDomain;
import com.solutions.digital.mixas.ordermanagement.core.service.productcategory.ProductCategoryService;
import com.solutions.digital.mixas.ordermanagement.rest.api.ProductCategoryApi;
import com.solutions.digital.mixas.ordermanagement.rest.dto.ProductCategory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductCategoryController implements ProductCategoryApi {

    private final ProductCategoryService productCategoryService;

    private final ProductCategoryMapper productCategoryMapper;

    public ProductCategoryController(ProductCategoryService productCategoryService, ProductCategoryMapper productCategoryMapper) {
        this.productCategoryService = productCategoryService;
        this.productCategoryMapper = productCategoryMapper;
    }


    @Override
    public ResponseEntity<List<ProductCategory>> findByCriteria(String name, String description) {
        ProductCategorySearchCriteriaDomain criteria = ProductCategorySearchCriteriaDomain.builder()
                .name(name)
                .description(description)
                .build();
        List<ProductCategoryDomain> productsCategoriesByCriteria = productCategoryService.getProductCategoryDomainsByCriteria(criteria);

        return ResponseEntity.ok(productCategoryMapper.domainToDto(productsCategoriesByCriteria));
    }

    @Override
    public ResponseEntity<ProductCategory> addProduct(ProductCategory productCategory) {
            return ResponseEntity.ok(productCategoryMapper.domainToDto(productCategoryService.addProductCategory(productCategoryMapper.dtoToDomain(productCategory))));
    }

}
