package com.fastcampus.jpa.bookmanager2.repository;

import com.fastcampus.jpa.bookmanager2.domain.TestTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestTestRepositoryTest {
	@Autowired
	private TestTestRepository testTestRepository;

	@Test
	public void test() {
		TestTest test = new TestTest();
		test.setName("parksh");
		test.setNickName("seunpark");
		testTestRepository.save(test);

		test.setName("martin");

		testTestRepository.save(test);

		testTestRepository.findAll().forEach(System.out::println);
	}

}
