package com.diegoyandun.exam.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegoyandun.exam.repository.Book;
import com.diegoyandun.exam.repository.BookRepository;


@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getall")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getBookById(@PathVariable(value = "id")Long bookId){
		Optional<Book> oBook = bookRepository.findById(bookId);
		
		if(!oBook.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oBook);
	}
	
	//Post
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/save")
	public ResponseEntity<Book> saveBook(@RequestBody Book bookDetails ){
		//Optional<Book> book = bookRepository.findById(bookId);
		bookRepository.save(bookDetails);
		return ResponseEntity.status(HttpStatus.CREATED).body(bookDetails);
	}
	
	//Update a Book
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/update/{id}")
	public ResponseEntity<Book> updateBook(@RequestBody Book bookDetails, @PathVariable(value = "id") Long bookId ){
		Optional<Book> book = bookRepository.findById(bookId);
		
		if(!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		//BeanUtils.copyProperties(bookDetails, book.get());
		book.get().setNombre(bookDetails.getNombre());
		book.get().setDescripcion(bookDetails.getDescripcion());
		book.get().setFecha_pub(bookDetails.getFecha_pub());
		book.get().setNum_ejem(bookDetails.getNum_ejem());
		book.get().setAutor(bookDetails.getAutor());
		book.get().setCosto(bookDetails.getCosto());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(book.get()));
	}
	
	//Delete a Book
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId){
		if(!bookRepository.findById(bookId).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		bookRepository.deleteById(bookId);
		return ResponseEntity.ok().build();
		
	}
	
	//Read all books 
	
	
}
