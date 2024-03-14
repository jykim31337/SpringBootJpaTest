package com.skywhalelab.SpringBootJpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository  extends JpaRepository<Test, Long> {
	Test findById(long id);
}
