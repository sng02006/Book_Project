package com.example.book.controller;

import com.example.book.dto.authorDto.AuthorResponseDto;
import com.example.book.dto.authorDto.CreateAuthorRequestDto;
import com.example.book.dto.bookDto.BookResponseDto;
import com.example.book.dto.bookDto.CreateBookRequestDto;
import com.example.book.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping
    public ResponseEntity<AuthorResponseDto> save(@RequestBody CreateAuthorRequestDto requestDto) {
        AuthorResponseDto authorResponseDto = authorService.save(requestDto.getAuthorName());
        return new ResponseEntity<>(authorResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<AuthorResponseDto>> findAll() {
        List<AuthorResponseDto> authorResponseDto = authorService.findAll();
        return new ResponseEntity<>(authorResponseDto, HttpStatus.OK);
    }
}