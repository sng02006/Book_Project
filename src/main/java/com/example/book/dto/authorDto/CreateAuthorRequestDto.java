package com.example.book.dto.authorDto;

import lombok.Getter;

@Getter
public class CreateAuthorRequestDto {
    private String authorName;

    public CreateAuthorRequestDto(String authorName) {
        this.authorName = authorName;
    }
}
