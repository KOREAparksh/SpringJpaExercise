package com.fastcampus.jpa.bookmanager2.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class UserTest {
	@Test
	void test(){
		User user = new User();
		user.setEmail("martin@fast.com");
		user.setName("martin");
		user.setCreatedAt(LocalDateTime.now());
		user.setUpdatedAt(LocalDateTime.now());

		User user1 = new User(null, "martin", "martine@naver.om", LocalDateTime.now(), LocalDateTime.now());
		User user2 = new User("martin", "martin@ddd.com");

		User user3 = User.builder()
				.name("seunpark")
				.email("tmdk@nave.ccc")
				.build();
		System.out.println(">>> " + user.toString());
	}
}