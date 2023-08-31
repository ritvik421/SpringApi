package com.LibrarySystem.demo.Service;

import com.LibrarySystem.demo.models.Author;
import com.LibrarySystem.demo.models.Book;
import com.LibrarySystem.demo.repositories.AuthorRepository;
import com.LibrarySystem.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor(String name){
        Author author = authorRepository.findByName(name);
        String id = author.getId();
        return bookRepository.findByAuthorId(id);
    }

    public List<Author> getAuthorsByNameRegex(String namesRegex) {
        return authorRepository.findByNameRegex(namesRegex);
    }
}
