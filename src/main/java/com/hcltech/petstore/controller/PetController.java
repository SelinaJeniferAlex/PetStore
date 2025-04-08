package com.hcltech.petstore.controller;

import com.hcltech.petstore.dto.PetDTO;
import com.hcltech.petstore.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
//@RequiredArgsConstructor
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping
    public ResponseEntity<PetDTO> create(@RequestBody PetDTO dto) {
        return ResponseEntity.ok(petService.createPet(dto));
    }

    @GetMapping
    public ResponseEntity<List<PetDTO>> getAll() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(petService.getPetById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PetDTO> update(@PathVariable Long id, @RequestBody PetDTO dto) {
        return ResponseEntity.ok(petService.updatePet(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
