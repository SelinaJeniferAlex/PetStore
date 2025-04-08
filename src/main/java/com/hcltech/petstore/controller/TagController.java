package com.hcltech.petstore.controller;

import com.hcltech.petstore.dto.TagDTO;
import com.hcltech.petstore.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tags")
//@RequiredArgsConstructor
public class TagController {

    @Autowired
    private TagService tagService;

    @PostMapping
    public TagDTO create(@RequestBody TagDTO dto) {
        return tagService.createTag(dto);
    }

    @GetMapping
    public List<TagDTO> getAll() {
        return tagService.getAllTags();
    }

    @GetMapping("/{id}")
    public TagDTO getById(@PathVariable Long id) {
        return tagService.getTagById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        tagService.deleteTag(id);
    }
}
