package com.solutions.digital.mixas.ordermanagement.core.outbound.persistence;

import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductSearchCriteriaDomain;

import java.util.List;

public interface ProductPort {

    ProductDomain getProductDomainById(long id);

    List<ProductDomain> getProductDomainByCriteria(ProductSearchCriteriaDomain criteria);
}
