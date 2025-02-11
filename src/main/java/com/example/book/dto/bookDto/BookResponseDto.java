package com.example.book.dto.bookDto;

import com.example.book.entity.Book;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long id;
    private String bookTitle;

    public BookResponseDto(Long id, String bookTitle) {
        this.id = id;
        this.bookTitle = bookTitle;
    }

    public static BookResponseDto toDto(Book book) {
        return new BookResponseDto(book.getId(), book.getBookTitle());
    }
}
