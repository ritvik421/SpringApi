package com.LibrarySystem.demo.Service;

import com.LibrarySystem.demo.models.Author;
import com.LibrarySystem.demo.models.Book;
import com.LibrarySystem.demo.repositories.AuthorRepository;
import com.LibrarySystem.demo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RestTemplate restTemplate ;

    public Author saveAuthor(Author author) {
        return authorRepository.save(author);
    }

    public List<Book> getBooksByAuthor(String name){
//        Author author = authorRepository.findByName(name);
//        String id = author.getId();
//        return bookRepository.findByAuthorId(id);
        String baseUrl = "http://localhost:8082/api/books/getbookbyauthor?authorName=" + name;
//        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl)
//                .queryParam("authorName" , name);

//        String uri = builder.toUriString();

        return restTemplate.getForObject(baseUrl , List.class);




//        return restTemplate.getForObject("http://localhost:8082/api/books/getbookbyauthor",List.class) ;
    }

    public List<Author> getAuthorsByNameRegex(String namesRegex) {
        return authorRepository.findByNameRegex(namesRegex);
    }
}
