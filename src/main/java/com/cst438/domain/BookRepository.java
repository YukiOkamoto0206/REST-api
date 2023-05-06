package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface BookRepository extends CrudRepository <Book, Integer> {
	@Query("select a from Book a where a.book_id = :id")
	Book findByBookId(@Param("id") int id);
}
