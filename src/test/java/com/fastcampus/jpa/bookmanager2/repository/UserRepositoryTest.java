package com.fastcampus.jpa.bookmanager2.repository;

import com.fastcampus.jpa.bookmanager2.domain.User;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;

	@Test
	void crud(){
//		userRepository.save(new User());
//		userRepository.findAll().forEach(System.out::println);
	}

	@Test
	void crud2(){
//		List<User> users = userRepository.findAll(Sort.by(Sort.Direction.DESC, "name"));
//		List<User> users = userRepository.findAllById(Lists.newArrayList(1L, 3L, 5L));

//		User user1 = new User("jack", "jack@jjj.com");
//		User user2 = new User("steve", "steve@jjj.com");
//		userRepository.saveAll(Lists.newArrayList(user1, user2));
//
//		List<User> users = userRepository.findAll();
//		users.forEach(System.out::println);
	}

	@Test
//	@Transactional // getone은 entity에 대한 lazy한 로딩을 지원하고 있따
	void crud3(){
//		User user = userRepository.getOne(1L);
//		Optional<User> user = userRepository.findById(1L);
		User user = userRepository.findById(1L).orElse(null);
		System.out.println(user);
	}

	@Test
	void crud4(){
		userRepository.save(new User("new martin", "newmartin@slow.com"));
		userRepository.flush();
		userRepository.findAll().forEach(System.out::println);
	}
}