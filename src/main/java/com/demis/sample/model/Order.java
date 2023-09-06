package com.demis.sample.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "order_app")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private int quantity;
    @OneToOne(optional = false, fetch = FetchType.LAZY, mappedBy = "order")
    private Customer customer;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Product> product;
}
