package com.solutions.digital.mixas.ordermanagement.core.service.productcategory;

import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategoryDomain;
import com.solutions.digital.mixas.ordermanagement.core.domain.productcategory.ProductCategorySearchCriteriaDomain;
import com.solutions.digital.mixas.ordermanagement.core.outbound.persistence.ProductCategoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    private final ProductCategoryPort productCategoryPort;

    public ProductCategoryServiceImpl(ProductCategoryPort productCategoryPort) {
        this.productCategoryPort = productCategoryPort;
    }

    @Override
    public ProductCategoryDomain getProductCategoryDomainById(String id) {
        return productCategoryPort.getProductCategoryDomainById(id);
    }

    @Override
    public List<ProductCategoryDomain> getProductCategoryDomainsByCriteria(ProductCategorySearchCriteriaDomain criteria) {
        return productCategoryPort.getProductCategoryDomainsByCriteria(criteria);
    }

    @Override
    public ProductCategoryDomain addProductCategory(ProductCategoryDomain productCategoryDomain) {
        return productCategoryPort.addProductCategory(productCategoryDomain);
    }
}
