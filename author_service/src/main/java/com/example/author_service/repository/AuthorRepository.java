package com.example.author_service.repository;

import com.example.author_service.entity.Author;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepository {

    private List<Author> authors = new ArrayList<>();

    public AuthorRepository() {
        authors.add(new Author(1L, "George Orwell"));
        authors.add(new Author(2L, "J.K. Rowling"));
        authors.add(new Author(3L, "Harper Lee"));
        authors.add(new Author(4L, "J.R.R. Tolkien"));
        authors.add(new Author(5L, "Jane Austen"));
    }

    public List<Author> findAll() {
        return List.copyOf(authors);
    }

    public Author findById(Long id) {
        Author author= authors.stream()
                .filter((b)->b.getId().equals(id))
                .findFirst()
                .orElse(null);

        return author;
    }
}
