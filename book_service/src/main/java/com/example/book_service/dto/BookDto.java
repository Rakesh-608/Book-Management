package com.example.book_service.dto;

import com.example.book_service.entity.Author;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        Long id,
        @NotEmpty(message = "Title should not be empty")
        String title,
        @NotNull(message = "Author should not be null")
        Author author
) {
}
