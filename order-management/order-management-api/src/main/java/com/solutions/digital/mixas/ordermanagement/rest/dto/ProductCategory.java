package com.solutions.digital.mixas.ordermanagement.rest.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProductCategory {

    @NotNull
    private String name;

    @NotNull
    private String description;
}
