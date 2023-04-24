package com.solutions.digital.mixas.ordermanagement.core.service.product;

import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductDomain;
import com.solutions.digital.mixas.ordermanagement.core.outbound.persistence.ProductPort;
import com.solutions.digital.mixas.ordermanagement.core.domain.product.ProductSearchCriteriaDomain;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    private final ProductPort productPort;

    public ProductServiceImpl(ProductPort productPort) {
        this.productPort = productPort;
    }

    @Override
    public ProductDomain getById(long id) {
        return productPort.getProductDomainById(id);
    }

    @Override
    public List<ProductDomain> findByCriteria(ProductSearchCriteriaDomain criteria) {
        return productPort.getProductDomainByCriteria(criteria);
    }
}
