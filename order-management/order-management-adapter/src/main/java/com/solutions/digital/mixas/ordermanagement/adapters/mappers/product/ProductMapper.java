package com.solutions.digital.mixas.ordermanagement.adapters.mappers.product;

import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.product.ProductEntity;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductDomain;
import com.solutions.digital.mixas.ordermanagement.rest.dto.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface ProductMapper {

    Product domainToDto(ProductDomain productDomain);

    ProductDomain dtoToDomain(Product product);

    @Mapping(source = "productCategory.name", target = "categoryName")
    @Mapping(source = "productCategory.description", target = "categoryDescription")
    ProductDomain entityToDomain(ProductEntity productEntity);

    @Mapping(source = "categoryName", target = "productCategory.name")
    ProductEntity domainToEntity(ProductDomain productDomain);

    List<Product> domainToDto(List<ProductDomain> productDomainList);

    List<ProductDomain> dtoToDomain(List<Product> product);

    List<ProductDomain> entityToDomain(List<ProductEntity> productEntity);

    List<ProductEntity> domainToEntity(List<ProductDomain> productDomain);

}
