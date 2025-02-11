package com.example.book.service;

import com.example.book.dto.authorDto.AuthorResponseDto;
import com.example.book.dto.bookDto.BookResponseDto;
import com.example.book.entity.Author;
import com.example.book.entity.Book;
import com.example.book.entity.BookAuthor;
import com.example.book.repository.AuthorRepository;
import com.example.book.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    @Transactional
    public AuthorResponseDto save(String authorName) {
        Author author = new Author(authorName);
        Author savedAuthor = authorRepository.save(author);
        BookAuthor bookAuthor = new BookAuthor();

        return new AuthorResponseDto(savedAuthor.getId(), savedAuthor.getAuthorName());
    }

    public List<AuthorResponseDto> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(AuthorResponseDto::toDto)
                .toList();
    }
}
