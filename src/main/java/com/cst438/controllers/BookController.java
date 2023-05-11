package com.cst438.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.Book;
import com.cst438.domain.BookDTO;
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
	public ResponseEntity<?> checkout(@PathVariable Long bookId, @PathVariable Long patronId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		Patron patron = patronRepository.findById(patronId).orElse(null);
		if (book == null || patron == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bookId or patronId invalid");
		}
		book.setCheckout_date(new Date());
		bookRepository.save(book);
		BookDTO dto = new BookDTO(book.getBook_id(), book.getTitle(), book.getAuthor(), book.getCheckout_patron_id(), book.getCheckout_date());
		return ResponseEntity.ok(dto);
	}
	
	@PutMapping("/book/{bookId}/return")
	@Transactional
	public ResponseEntity<?> returnBook(@PathVariable Long bookId) {
		Book book = bookRepository.findById(bookId).orElse(null);
		if (book == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("bookId invalid");
		}
		book.setCheckout_date(null);
		book.setCheckout_patron_id(null);
		bookRepository.save(book);
		BookDTO dto = new BookDTO(book.getBook_id(), book.getTitle(), book.getAuthor(), book.getCheckout_patron_id(), book.getCheckout_date());
		return ResponseEntity.ok(dto);
	}
}
