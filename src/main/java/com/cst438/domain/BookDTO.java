package com.cst438.domain;

import java.util.Date;
import java.util.Objects;

public class BookDTO {
	public Long book_id;
	public String title; 
	public String author; 
	public Long checkout_patron_id;
	public Date checkout_date;
	
	public BookDTO() { };
	
	public BookDTO(Long book_id, String title, String author, Long checkout_patron_id, Date checkout_date) {
		this.book_id = book_id;
		this.title = title;
		this.author = author;
		this.checkout_patron_id = checkout_patron_id;
		this.checkout_date = checkout_date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookDTO other = (BookDTO) obj;
		return Objects.equals(author, other.author) && Objects.equals(book_id, other.book_id)
				&& Objects.equals(checkout_date, other.checkout_date)
				&& Objects.equals(checkout_patron_id, other.checkout_patron_id) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "BookDTO [book_id=" + book_id + ", title=" + title + ", author=" + author + ", checkout_patron_id="
				+ checkout_patron_id + ", checkout_date=" + checkout_date + "]";
	}
	
	
	
}
