package com.hcltech.petstore.serviceImpl;

import com.hcltech.petstore.dto.TagDTO;
import com.hcltech.petstore.mapper.EntityDtoMapper;
import com.hcltech.petstore.model.Tag;
import com.hcltech.petstore.repository.TagRepository;
import com.hcltech.petstore.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    @Autowired
    private final TagRepository tagRepository;
    @Autowired
    private final EntityDtoMapper mapper;

    @Override
    public TagDTO createTag(TagDTO dto) {
        Tag tag = new Tag();
        tag.setTagName(dto.getTagName());
        return mapper.toTagDTO(tagRepository.save(tag));
    }

    @Override
    public List<TagDTO> getAllTags() {
        return tagRepository.findAll().stream().map(mapper::toTagDTO).toList();
    }

    @Override
    public TagDTO getTagById(Long id) {
        return tagRepository.findById(id).map(mapper::toTagDTO)
                .orElseThrow(() -> new RuntimeException("Tag not found"));
    }

    @Override
    public void deleteTag(Long id) {
        tagRepository.deleteById(id);
    }
}
