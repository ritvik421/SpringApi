package com.LibrarySystem.demo.Service;

import com.LibrarySystem.demo.models.Book;
import com.LibrarySystem.demo.repositories.AuthorRepository;
import com.LibrarySystem.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
//    	System.out.println("Hi");
        return bookRepository.findAll();
    }

    public List<Book> getBooksByGenre(@RequestParam String genre) {
//    	System.out.println("Hey");
        return bookRepository.findByGenre(genre);
    }


    public List<Book> getBooksByGenreAndCopiesAvailable(@RequestParam String genre, @RequestParam int copies) {
        return bookRepository.findByGenreAndCopiesAvailableGreaterThan(genre, copies);
    }

    public ResponseEntity<Book> saveBook(@Valid @RequestBody Book book) {
        Book savedBook = bookRepository.save(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
}
