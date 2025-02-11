package com.example.book.dto.authorDto;

import com.example.book.entity.Author;
import lombok.Getter;

@Getter
public class AuthorResponseDto {
    private Long id;
    private String authorName;

    public AuthorResponseDto(Long id, String authorName) {
        this.id = id;
        this.authorName = authorName;
    }

    public static AuthorResponseDto toDto(Author author) {
        return new AuthorResponseDto(author.getId(), author.getAuthorName());
    }
}