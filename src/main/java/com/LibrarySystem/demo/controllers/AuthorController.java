package com.LibrarySystem.demo.controllers;

import com.LibrarySystem.demo.Service.AuthorService;
import com.LibrarySystem.demo.Service.BookService;
import com.LibrarySystem.demo.models.Author;
import com.LibrarySystem.demo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public Author saveAuthor(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }
    @GetMapping("/author")
    public List<Book> getBooksByAuthor(@RequestParam String name){
        return authorService.getBooksByAuthor(name);
    }

    @GetMapping("/get")
    public List<Author> getAuthorsByNameRegex(@RequestParam String namesRegex) {
        return authorService.getAuthorsByNameRegex(namesRegex);
    }
}
