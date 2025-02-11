package com.example.book.dto.bookDto;

import lombok.Getter;

@Getter
public class CreateBookRequestDto {
    private String bookTitle;

    public CreateBookRequestDto(String bookTitle) {
        this.bookTitle = bookTitle;
    }
}
