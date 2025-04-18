package com.hcltech.petstore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagDTO {

    private Long tagId;

    private String tagName;
}
