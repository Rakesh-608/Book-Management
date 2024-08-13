package com.example.book_service.controller;

import com.example.book_service.client.AuthorClient;
import com.example.book_service.dto.BookDto;
import com.example.book_service.entity.Book;
import com.example.book_service.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {
//    @Autowired
    private final BookRepository bookRepository;

//    @Autowired
    private final AuthorClient authorClient;

    public BookController(BookRepository bookRepository, AuthorClient authorClient) {
        this.bookRepository = bookRepository;
        this.authorClient = authorClient;
    }

    @GetMapping("/books")
    public List<BookDto> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        List<BookDto> bookDtos = new ArrayList<>();
        for (Book book : books) {
            BookDto bookDto = new BookDto(book.getId(),book.getTitle(),authorClient.getAuthorById(book.getId()));
            bookDtos.add(bookDto);
        }
        return bookDtos;
    }

    @GetMapping("/books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id);
        BookDto dto=new BookDto(book.getId(),book.getTitle(),authorClient.getAuthorById(book.getId()));
        return dto;
    }

}
