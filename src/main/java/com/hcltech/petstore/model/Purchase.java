package com.hcltech.petstore.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Long purchaseId;

    @ManyToOne
    @Column(name = "customer")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "pet_id")
    @Column(name = "pet")
    private Pet pet;

    @Column(name = "purchase_date")
    private LocalDateTime purchaseDate;

    @Column(name = "returned")
    private boolean returned;


}
