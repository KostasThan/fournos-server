package com.solutions.digital.mixas.ordermanagement.adapters.outbound.persistence.entities.productcategory;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_categories")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ProductCategoryEntity {


    @Id
    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, unique = true)
    private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductCategoryEntity that = (ProductCategoryEntity) o;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
