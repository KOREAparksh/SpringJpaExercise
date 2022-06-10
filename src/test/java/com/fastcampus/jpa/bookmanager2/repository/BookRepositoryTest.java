package com.fastcampus.jpa.bookmanager2.repository;

import com.fastcampus.jpa.bookmanager2.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRepositoryTest {
	@Autowired
	private BookRepository bookRepository;

	@Test
	void bookTest() {
		Book book = new Book();
		book.setName("jpa 초격차 패키지");
		book.setName("fastcampus");

		bookRepository.save(book);

		System.out.println(bookRepository.findAll());
	}
}
