package com.cst438.domain;

import java.util.Objects;

public class PatronDTO {
	public Long patron_id;
	public String name;
	public BookDTO[] books;
	
	public PatronDTO() {};
	
	public PatronDTO(Long patron_id, String name, BookDTO[] books) {
		this.patron_id = patron_id;
		this.name = name;
		this.books = books;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PatronDTO other = (PatronDTO) obj;
		return Objects.equals(name, other.name) && Objects.equals(patron_id, other.patron_id);
	}

	@Override
	public String toString() {
		return "PatronDTO [patron_id=" + patron_id + ", name=" + name + "]";
	}
}
