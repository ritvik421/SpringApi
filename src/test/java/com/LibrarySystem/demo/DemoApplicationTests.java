package com.LibrarySystem.demo;

import com.LibrarySystem.demo.Service.AuthorService;
import com.LibrarySystem.demo.Service.BookService;
import com.LibrarySystem.demo.models.Author;
import com.LibrarySystem.demo.models.Book;
import com.LibrarySystem.demo.repositories.AuthorRepository;
import com.LibrarySystem.demo.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mockito.Mockito.when ;
import static org.junit.Assert.assertEquals ;
@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private AuthorService authorService ;
	@Autowired
	private BookService bookService ;

	@MockBean
	private AuthorRepository arepo ;

	@MockBean
	private BookRepository brepo ;
//	@Test
//	void contextLoads() {
//	}

	@Test
	public void getAllBooksTest(){
     when(brepo.findAll()).thenReturn(Stream.of(new Book("4",40,"8","fiction"),new Book("8",60,"9","romantic")).collect(Collectors.toList())) ;
     assertEquals(2,bookService.getAllBooks().size());
	}
	@Test
	public void getBooksByGenreTests(){
      String genre = "Romantic" ;
	  when(brepo.findByGenre(genre)).thenReturn(Stream.of(new Book("4",40,"8","fiction")).collect(Collectors.toList())) ;
	  assertEquals(1,bookService.getBooksByGenre(genre).size());
	}
	@Test
	public void getBooksByGenreAndCopiesAvailableTests(){
		String genre = "Horror" ;
		int copiesAvailable = 8 ;
		when(brepo.findByGenreAndCopiesAvailableGreaterThan(genre,copiesAvailable)).thenReturn(Stream.of(new Book("4",40,"8","fiction")).collect(Collectors.toList())) ;
		assertEquals(1,bookService.getBooksByGenreAndCopiesAvailable(genre,copiesAvailable).size());
	}

	@Test
	public void getBooksByAuthorTests(){
		String name= "Sid" ;
		Author author =  new Author("6","Rit",null) ;
		when(arepo.findByName(name)).thenReturn(author) ;
		when(brepo.findByAuthorId("6")).thenReturn(Stream.of(new Book("4",40,"6","fiction")).collect(Collectors.toList())) ;
        assertEquals(author.getId(),authorService.getBooksByAuthor((name)).get(0).getAuthorId());
	}
	@Test
	public void getAuthorsBynameRegexTests(){
	  String nameRegex= "Rit" ;
	  when(arepo.findByNameRegex(nameRegex)).thenReturn(Stream.of(new Author("8","Dhruv",null)).collect(Collectors.toList())) ;
	  assertEquals(1,authorService.getAuthorsByNameRegex(nameRegex).size());
	}

}
