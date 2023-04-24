package com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.repositories.productcategory;

import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory.ProductCategoryEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductCategoryRepository extends CrudRepository<ProductCategoryEntity, String>, JpaSpecificationExecutor<ProductCategoryEntity> {
}
