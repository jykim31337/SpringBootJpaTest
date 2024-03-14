package com.skywhalelab.SpringBootJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing
public class SpringBootJpaTestApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootJpaTestApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaTestApplication.class, args);
	}
	
	@Bean
	CommandLineRunner demo(TestRepository repository) {
		return (args) -> {
			
			for(int i = 0; i < 1; i++) {
//				Test test = Test.builder().build();
				Test test = new Test();
				
				System.out.println(test.toString());
				
				repository.save(test);
			}
			
			repository.findAll().forEach(test -> {
				log.info(test.toString());
			});
			
		};
	}

}
