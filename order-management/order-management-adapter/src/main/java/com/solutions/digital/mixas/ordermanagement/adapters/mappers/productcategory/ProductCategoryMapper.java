package com.solutions.digital.mixas.ordermanagement.adapters.mappers.productcategory;

import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.product.ProductEntity;
import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory.ProductCategoryEntity;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategoryDomain;
import com.solutions.digital.mixas.ordermanagement.rest.dto.ProductCategory;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ProductCategoryMapper {

    ProductCategory domainToDto(ProductCategoryDomain productCategory);

    ProductCategoryDomain dtoToDomain(ProductCategory productCategory);

    ProductCategoryDomain entityToDomain(ProductCategoryEntity entity);

    ProductCategoryEntity domainToEntity(ProductCategoryDomain domain);

    List<ProductCategory> domainToDto(List<ProductCategoryDomain>productCategory);

    List<ProductCategoryDomain> dtoToDomain(List<ProductCategory> productCategory);

    List<ProductCategoryDomain> entityToDomain(List<ProductCategoryEntity> entity);

    List<ProductCategoryEntity> domainToEntity(List<ProductCategoryDomain> domain);

}
