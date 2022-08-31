package com.example.restful_blog.dto;

import com.example.restful_blog.model.Categories;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDto {

    private int id;

    @NotBlank
    private String title;

    @NotNull
    private Categories category;

    @NotBlank
    private String summary;

    @NotBlank
    private String content;

    @NotBlank
    private String author;
}
