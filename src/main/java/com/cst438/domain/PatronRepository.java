package com.cst438.domain;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
public interface PatronRepository extends CrudRepository <Patron, Integer> {
	@Query("select a from Patron a where a.patron_id = :id")
	Patron findByPatronId(@Param("id") int id);
}
