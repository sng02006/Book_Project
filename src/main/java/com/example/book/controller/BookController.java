package com.example.book.controller;

import com.example.book.dto.bookDto.BookResponseDto;
import com.example.book.dto.bookDto.CreateBookRequestDto;
import com.example.book.entity.Book;
import com.example.book.service.AuthorService;
import com.example.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponseDto> save(@RequestBody CreateBookRequestDto requestDto) {
        BookResponseDto bookResponseDto = bookService.save(requestDto.getBookTitle());
        return new ResponseEntity<>(bookResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDto>> findAll() {
        List<BookResponseDto> bookResponseDtoList = bookService.findAll();
        return new ResponseEntity<>(bookResponseDtoList, HttpStatus.OK);
    }
}