package com.example.book_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.book_service.entity.Author;

//@Service
@FeignClient(name = "author-service", url = "http://localhost:8200")
public interface AuthorClient {
    @GetMapping("/authors/{id}")
    public Author getAuthorById(@PathVariable("id") Long id);
}
