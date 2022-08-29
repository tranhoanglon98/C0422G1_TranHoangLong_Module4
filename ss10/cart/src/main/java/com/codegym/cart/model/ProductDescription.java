package com.codegym.cart.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String description;

    @ManyToMany
    @JoinTable(name = "description_product",joinColumns = @JoinColumn(name = "description_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> productList;

}
