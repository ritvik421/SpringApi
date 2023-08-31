package com.LibrarySystem.demo.controllers;


import com.LibrarySystem.demo.Service.AuthorService;
import com.LibrarySystem.demo.Service.BookService;
import com.LibrarySystem.demo.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @Autowired
    private AuthorService authorService;

    @GetMapping("/")
    public List<Book> getAllBooks() {
//    	System.out.println("Hi");
        return bookService.getAllBooks();
    }

    @GetMapping("/genre")
    public List<Book> getBooksByGenre(@RequestParam String genre) {
//    	System.out.println("Hey");
        return bookService.getBooksByGenre(genre);
    }


    @GetMapping("/genreAndCopies")
    public List<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre, @RequestParam int copies) {
        return bookService.getBooksByGenreAndCopiesAvailable(genre, copies);
    }

    @PostMapping("/add")
    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        return bookService.saveBook(book);
    }
}
