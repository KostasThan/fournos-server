package com.solutions.digital.mixas.ordermanagement.core.service.productcategory;

import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategoryDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategorySearchCriteriaDomain;

import java.util.List;


public interface ProductCategoryService {

    ProductCategoryDomain getProductCategoryDomainById(String id);

    List<ProductCategoryDomain> getProductCategoryDomainsByCriteria(ProductCategorySearchCriteriaDomain criteria);

    ProductCategoryDomain addProductCategory(ProductCategoryDomain productCategoryDomain);
}
