package com.example.book.service;

import com.example.book.dto.bookDto.BookResponseDto;
import com.example.book.entity.Book;
import com.example.book.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookResponseDto save(String bookTitle) {
        Book book = new Book(bookTitle);
        Book savedBook = bookRepository.save(book);
        return new BookResponseDto(savedBook.getId(), savedBook.getBookTitle());
    }

    public List<BookResponseDto> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(BookResponseDto::toDto)
                .toList();
    }
}