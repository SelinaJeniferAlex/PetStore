package com.hcltech.petstore.service;
import com.hcltech.petstore.dto.TagDTO;

import java.util.List;

public interface TagService {

    TagDTO createTag(TagDTO dto);
    List<TagDTO> getAllTags();
    TagDTO getTagById(Long id);
    void deleteTag(Long id);
}
