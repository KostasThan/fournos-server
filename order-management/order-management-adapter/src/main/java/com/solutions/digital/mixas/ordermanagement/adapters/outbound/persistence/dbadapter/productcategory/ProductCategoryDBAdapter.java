package com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.dbadapter.productcategory;

import com.solutions.digital.mixas.ordermanagement.adapters.mappers.productcategory.ProductCategoryMapper;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory.ProductCategoryEntity;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory.ProductCategoryEntity_;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.repositories.productcategory.ProductCategoryRepository;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategoryDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategorySearchCriteriaDomain;
import com.solutions.digital.mixas.ordermanagement.core.outbound.persistence.ProductCategoryPort;
import com.solutions.digital.mixas.shared.SpecificationUtils;
import com.solutions.digital.mixas.shared.exceptions.MixasAlreadyExistsException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.springframework.data.jpa.domain.Specification.where;

@Component
public class ProductCategoryDBAdapter implements ProductCategoryPort{

    private final ProductCategoryMapper productCategoryMapper;

    private final ProductCategoryRepository productCategoryRepository;


    public ProductCategoryDBAdapter(ProductCategoryMapper productCategoryMapper, ProductCategoryRepository productCategoryRepository) {
        this.productCategoryMapper = productCategoryMapper;
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategoryDomain getProductCategoryDomainById(String id){
        ProductCategoryEntity productEntity = productCategoryRepository.findById(id).orElseGet(ProductCategoryEntity::new);
        return productCategoryMapper.entityToDomain(productEntity);
    }

    @Override
    public List<ProductCategoryDomain> getProductCategoryDomainsByCriteria(ProductCategorySearchCriteriaDomain criteria) {
        Specification<ProductCategoryEntity> specification = where(hasName(criteria.getName()))
                .and(hasDescription(criteria.getDescription()));

        List<ProductCategoryEntity> entities = productCategoryRepository.findAll(specification);

        return productCategoryMapper.entityToDomain(entities);
    }

    @Override
    public ProductCategoryDomain addProductCategory(ProductCategoryDomain productCategoryDomain) {
        if (productCategoryRepository.findById(productCategoryDomain.getName()).isPresent()) {
            throw new MixasAlreadyExistsException(productCategoryDomain.getName());
        }
        return productCategoryMapper.entityToDomain(productCategoryRepository.save(productCategoryMapper.domainToEntity(productCategoryDomain)));
    }

    private Specification<ProductCategoryEntity> hasName(String name){
        return SpecificationUtils.numberEquals(name, ProductCategoryEntity_.NAME);
    }

    private Specification<ProductCategoryEntity> hasDescription(String description){
        return SpecificationUtils.numberEquals(description, ProductCategoryEntity_.DESCRIPTION);
    }

}