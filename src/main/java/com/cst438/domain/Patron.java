package com.cst438.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patrons")
public class Patron {
	@Id
	private Long patron_id;
	private String name;
	
	@OneToMany(mappedBy="patron")
	private List<Book> books;

	public Long getPatron_id() {
		return patron_id;
	}

	public void setPatron_id(Long patron_id) {
		this.patron_id = patron_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
