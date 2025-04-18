package com.hcltech.petstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;

    private String customerName;

    @Column(unique = true)
    private String customerEmail;

    private String customerPhone;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Purchase> purchases;

}
