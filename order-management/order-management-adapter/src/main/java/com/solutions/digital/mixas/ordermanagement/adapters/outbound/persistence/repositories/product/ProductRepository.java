package com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.repositories.product;

import com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
}
