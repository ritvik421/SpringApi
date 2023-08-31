package com.LibrarySystem.demo.repositories;

import com.LibrarySystem.demo.models.Author;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AuthorRepository extends MongoRepository<Author, String> {
    List<Author> findByNameRegex(String regex);
    Author findByName(String name);
}
