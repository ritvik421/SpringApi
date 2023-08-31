package com.LibrarySystem.demo.repositories;

import com.LibrarySystem.demo.models.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, String> {
    List<Book> findByGenre(String genre);
    List<Book> findByGenreAndCopiesAvailableGreaterThan(String genre, int copies);
    List<Book> findByAuthorId(String authorId);
}
