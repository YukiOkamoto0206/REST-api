package com.cst438.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="books")
public class Book {
	@Id
	private Long book_id;
	private String title; 
	private String author; 
	private Long checkout_patron_id;
	private Date checkout_date;
	
//	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="checkout_patron_id", insertable = false, updatable = false)
	private Patron patron;

	public Long getBook_id() {
		return book_id;
	}

	public void setBook_id(Long book_id) {
		this.book_id = book_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Long getCheckout_patron_id() {
		return checkout_patron_id;
	}

	public void setCheckout_patron_id(Long checkout_patron_id) {
		this.checkout_patron_id = checkout_patron_id;
	}

	public Date getCheckout_date() {
		return checkout_date;
	}

	public void setCheckout_date(Date checkout_date) {
		this.checkout_date = checkout_date;
	}

	public Patron getPatron() {
		return patron;
	}

	public void setPatron(Patron patron) {
		this.patron = patron;
	}
	
	
}
