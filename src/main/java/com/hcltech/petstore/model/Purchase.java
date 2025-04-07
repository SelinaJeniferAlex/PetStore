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
    private Long purchaseId;

    @ManyToOne
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    private LocalDateTime purchaseDate;

    private boolean returned = false;


}
