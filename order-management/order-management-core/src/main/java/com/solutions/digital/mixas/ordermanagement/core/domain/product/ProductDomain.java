package com.solutions.digital.mixas.ordermanagement.core.domain.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDomain {

    private long id;

    private String name;

    private double price;

    private String categoryName;

    private String categoryDescription;
}
