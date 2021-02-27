package com.diegoyandun.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.diegoyandun.exam.repository.Book;
import com.diegoyandun.exam.repository.BookRepository;



@SpringBootApplication
public class CrudBookApplication implements CommandLineRunner {

	@Autowired
	private BookRepository bookRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudBookApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Book> books = bookRepo.findAll();
		books.forEach(System.out:: println);
		
	}

}
