package com.diegoyandun.exam.services;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diegoyandun.exam.repository.Book;
import com.diegoyandun.exam.repository.BookRepository;


@RestController
@RequestMapping("/api/v1")
public class BookController {
	@Autowired
	private BookRepository bookRepository;
	
	
	//Get all books
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getall3")
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	//Get a book by Id
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getBookById(@PathVariable(value = "id")Long bookId){
		Optional<Book> oBook = bookRepository.findById(bookId);
		
		if(!oBook.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oBook);
	}
	
	//Create a book
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
	
	//Read all books pageable 
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getall1")
	public String Obtener(@RequestParam Map<String, Object> params, Model model){
		int page = params.get("page") != null ? (Integer.valueOf(params.get("page").toString()) - 1) : 0;
		PageRequest pageRequest = PageRequest.of(page, 10);
		Page<Book> pageBook = bookRepository.findAll(pageRequest);
		
		int totalPage = pageBook.getTotalPages();
		if(totalPage > 0) {
			List<Integer> pages = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
			model.addAttribute("pages", pages);
		}
		model.addAttribute("list", pageBook.getContent());
		
		return "index";
			
	}
	//Read all books pageable 
		@CrossOrigin(origins = "http://localhost:4200")
		@GetMapping("/getall")
		public ResponseEntity<Page<Book>> paginas(
				@RequestParam(defaultValue = "0")int page,
				@RequestParam(defaultValue = "10") int size,
				@RequestParam(defaultValue = "nombre") String order,
				@RequestParam(defaultValue = "true") boolean asc)
		{
			Page<Book> books = bookRepository.findAll(
					PageRequest.of(page, size, Sort.by(order)));
					if(!asc) {
						books = bookRepository.findAll(PageRequest.of(page, size, Sort.by(order).descending()));
					}
					//return  ResponseEntity<Page<Book>>;
					return ResponseEntity.ok(books);
					
		}
	
}
