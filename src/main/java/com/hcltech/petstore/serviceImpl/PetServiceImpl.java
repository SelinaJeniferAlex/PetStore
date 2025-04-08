package com.hcltech.petstore.serviceImpl;

import com.hcltech.petstore.dto.PetDTO;
import com.hcltech.petstore.mapper.EntityDtoMapper;
import com.hcltech.petstore.model.Pet;
import com.hcltech.petstore.repository.CategoryRepository;
import com.hcltech.petstore.repository.PetRepository;
import com.hcltech.petstore.repository.TagRepository;
import com.hcltech.petstore.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService {

    @Autowired
    private final PetRepository petRepository;
    @Autowired
    private final CategoryRepository categoryRepository;
    @Autowired
    private final TagRepository tagRepository;
    @Autowired
    private final EntityDtoMapper mapper;

    @Override
    public PetDTO createPet(PetDTO petDTO) {
        Pet pet = mapper.toPetEntity(petDTO);
        pet.setCategory(categoryRepository.findById(petDTO.getCategory().getCategoryId()).orElseThrow());
        pet.setTags(petDTO.getTags().stream()
                .map(tagDTO -> tagRepository.findById(tagDTO.getTagId()).orElseThrow())
                .collect(Collectors.toSet()));
        return mapper.toPetDTO(petRepository.save(pet));
    }

    @Override
    public List<PetDTO> getAllPets() {
        return petRepository.findAll().stream()
                .filter(Pet::isAvailable)
                .map(mapper::toPetDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PetDTO getPetById(Long id) {
        return mapper.toPetDTO(petRepository.findById(id).orElseThrow());
    }

    @Override
    public PetDTO updatePet(Long id, PetDTO petDTO) {
        Pet pet = petRepository.findById(id).orElseThrow();
        pet.setPetName(petDTO.getPetName());
        pet.setAge(petDTO.getAge());
        pet.setBreed(petDTO.getBreed());
        pet.setGender(petDTO.getGender());
        pet.setPrice(petDTO.getPrice());
        return mapper.toPetDTO(petRepository.save(pet));
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);
    }
}
