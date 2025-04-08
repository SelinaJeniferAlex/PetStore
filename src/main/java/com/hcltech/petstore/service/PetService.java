package com.hcltech.petstore.service;

import com.hcltech.petstore.dto.PetDTO;

import java.util.List;

public interface PetService {

    PetDTO createPet(PetDTO petDTO);
    List<PetDTO> getAllPets();
    PetDTO getPetById(Long id);
    PetDTO updatePet(Long id, PetDTO petDTO);
    void deletePet(Long id);
}
