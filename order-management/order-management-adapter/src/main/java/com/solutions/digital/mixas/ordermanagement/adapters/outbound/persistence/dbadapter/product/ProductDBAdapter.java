package com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.dbadapter.product;

import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.product.ProductEntity_;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory.ProductCategoryEntity_;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductDomain;
import com.solutions.digital.mixas.ordermanagement.core.outbound.persistence.ProductPort;
import com.solutions.digital.mixas.shared.SpecificationUtils;
import com.solutions.digital.mixas.ordermanagement.adapters.mappers.product.ProductMapper;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.product.ProductEntity;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.repositories.product.ProductRepository;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductSearchCriteriaDomain;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class ProductDBAdapter implements ProductPort {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    public ProductDBAdapter(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public ProductDomain getProductDomainById(long id) {
        return productMapper.entityToDomain(productRepository.findById(id).orElse(new ProductEntity()));
    }

    @Override
    public List<ProductDomain> getProductDomainByCriteria(ProductSearchCriteriaDomain criteria) {
        Specification<ProductEntity> specification = Specification.where(hasName(criteria.getName()))
                .and(hasId(criteria.getId()))
                .and(hasPrice(criteria.getPrice()))
                .and(hasMinimumPrice(criteria.getMinimumPrice()))
                .and(hasMaximumPrice(criteria.getMaximumPrice()))
                .and(hasCategoryName(criteria.getCategoryName()))
                .and(hasCategoryDescription(criteria.getCategoryDescription()));

        return productMapper.entityToDomain(productRepository.findAll(specification));
    }

    private Specification<ProductEntity> hasName(String name) {
        return SpecificationUtils.equalsIgnoreCase(name, ProductEntity_.NAME);
    }

    private Specification<ProductEntity> hasPrice(Double price) {
        return SpecificationUtils.numberEquals(price, ProductEntity_.PRICE);
    }

    private Specification<ProductEntity> hasId(Long id) {
        return SpecificationUtils.numberEquals(id, ProductEntity_.ID);
    }

    private Specification<ProductEntity> hasCategoryName(Set<String> categoryNames) {
        return SpecificationUtils.inListIgnoreCase(categoryNames,
                root -> root.get(ProductEntity_.productCategory).get(ProductCategoryEntity_.NAME));
    }

    private Specification<ProductEntity> hasCategoryDescription(Set<String> categoryDescriptions) {
        return SpecificationUtils.inListIgnoreCase(categoryDescriptions,
                root -> root.get(ProductEntity_.productCategory).get(ProductCategoryEntity_.DESCRIPTION));
    }


    private Specification<ProductEntity> hasMinimumPrice(Double minimumPrice) {
        return SpecificationUtils.greaterThanOrEqualTo(minimumPrice, ProductEntity_.PRICE);
    }


    private Specification<ProductEntity> hasMaximumPrice(Double maximumPrice) {
        return SpecificationUtils.lessThanOrEqualTo(maximumPrice, ProductEntity_.PRICE);
    }


}
