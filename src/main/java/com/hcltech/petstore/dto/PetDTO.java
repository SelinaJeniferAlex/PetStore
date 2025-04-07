package com.hcltech.petstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private Long petId;

    private String petName;

    private int age;

    private String breed;

    private String gender;

    private BigDecimal price;

    private boolean available;

    private CategoryDTO category;

    private Set<TagDTO> tags;
}
