package com.cst438.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cst438.domain.Book;
import com.cst438.domain.BookDTO;
import com.cst438.domain.BookRepository;
import com.cst438.domain.Patron;
import com.cst438.domain.PatronDTO;
import com.cst438.domain.PatronRepository;

@RestController
public class PatronController {
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	PatronRepository patronRepository;
	
	@GetMapping("/patron/{patronId}")
	@Transactional
	public ResponseEntity<?> getPatron(@PathVariable Long patronId) {
		System.out.println(patronId);
		Patron patron = patronRepository.findById(patronId).orElse(null);
		if (patron == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("patronId invalid");
		}
		BookDTO[] books = listToBookDtoConverter(patron.getBooks());
		PatronDTO dto = new PatronDTO(patron.getPatron_id(), patron.getName(), books);
		return ResponseEntity.ok(dto);
	}
	
	private BookDTO[] listToBookDtoConverter(List<Book> books) {
		BookDTO[] dto = new BookDTO[books.size()];
		for (int i = 0; i < books.size(); i++) {
			Book book = books.get(i);
			dto[i] = new BookDTO(book.getBook_id(), book.getTitle(), book.getAuthor(), book.getCheckout_patron_id(), book.getCheckout_date());
		}
		return dto;
	}
}
