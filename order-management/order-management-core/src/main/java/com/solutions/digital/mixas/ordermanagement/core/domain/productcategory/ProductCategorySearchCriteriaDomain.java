package com.solutions.digital.mixas.ordermanagement.core.domain.productcategory;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategorySearchCriteriaDomain {
    private String name;

    private String description;
}
