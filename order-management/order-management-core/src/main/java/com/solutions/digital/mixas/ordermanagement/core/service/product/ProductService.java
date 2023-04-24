package com.solutions.digital.mixas.ordermanagement.core.service.product;

import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductSearchCriteriaDomain;

import java.util.List;

public interface ProductService {

    ProductDomain getById(long id);

    List<ProductDomain> findByCriteria(ProductSearchCriteriaDomain criteria);
}
