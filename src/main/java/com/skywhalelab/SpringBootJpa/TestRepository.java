package com.skywhalelab.SpringBootJpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface TestRepository  extends JpaRepository<Test, Long> {
	List<Test> findByTitle(String title);
	Test findById(long id);
}
