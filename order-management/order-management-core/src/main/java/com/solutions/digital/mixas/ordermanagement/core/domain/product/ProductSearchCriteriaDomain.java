package com.solutions.digital.mixas.ordermanagement.core.domain.product;

import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@Builder
public class ProductSearchCriteriaDomain{

    private Long id;

    private String name;

    private Double price;

    private Double minimumPrice;

    private Double maximumPrice;

    private Set<String> categoryName;

    private Set<String> categoryDescription;


}
