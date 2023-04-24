package com.solutions.digital.mixas.ordermanagement.rest.dto;

import lombok.Data;

@Data
public class Product {

    private long id;

    private double price;

    private String name;

    private String categoryName;

    private String categoryDescription;
}
