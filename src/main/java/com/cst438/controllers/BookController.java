package com.cst438.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.Book;
import com.cst438.domain.BookRepository;
import com.cst438.domain.Patron;
import com.cst438.domain.PatronRepository;

@RestController
public class BookController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PatronRepository patronRepository;
	
	@PutMapping("/book/{bookId}/checkout/{patronId}")
	@Transactional
	public ResponseEntity<String> checkout(@PathVariable int bookId, @PathVariable int patronId) {
		Book book = bookRepository.findByBookId(bookId);
		Patron patron = patronRepository.findByPatronId(patronId);
		if (book == null || patron == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bookId or patronId invalid");
		}
		book.setCheckout_date(new Date());
		bookRepository.save(book);
		return ResponseEntity.ok("");
	}
	
	@PutMapping("/book/{bookId}/return")
	@Transactional
	public ResponseEntity<String> returnBook(@PathVariable int bookId) {
		Book book = bookRepository.findByBookId(bookId);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bookId invalid");
		}
		book.setCheckout_date(null);
		book.setCheckout_patron_id((Integer) null);
		bookRepository.save(book);
		return ResponseEntity.ok("");
	}
	
	@GetMapping("/patron/{patronId}")
	@Transactional
	public ResponseEntity<?> getPatron(@PathVariable Integer patronId) {
		Patron patron = patronRepository.findById(patronId).orElse(null);
		if (patron == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patronId invalid");
		}
		return ResponseEntity.ok(patron);
	}
}
