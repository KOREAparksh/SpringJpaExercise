package com.fastcampus.jpa.bookmanager2.service;

import com.fastcampus.jpa.bookmanager2.domain.User;
import com.fastcampus.jpa.bookmanager2.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@SpringBootTest
@Transactional
public class EntityManagerTest {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private UserRepository userRepository;

	@Test
	void entityManagerTest(){
		System.out.println(entityManager.createQuery("select u from User u").getResultList());
	}

	@Test
	void cacheFindTest(){
//		System.out.println(userRepository.findByEmail("martin@fast.com"));
//		System.out.println(userRepository.findByEmail("martin@fast.com"));
//		System.out.println(userRepository.findByEmail("martin@fast.com"));
//		System.out.println(userRepository.findById(2L).get());
//		System.out.println(userRepository.findById(2L).get());
//		System.out.println(userRepository.findById(2L).get());

		userRepository.deleteById(1L);
	}

	@Test
	void  cacheFindTest2(){
		User user = userRepository.findById(1L).get();
		user.setName("marrrrrtin");
		userRepository.save(user);

		System.out.println("--------------------------");

		user.setEmail("marrrrrrtin@fast.com");
		userRepository.save(user);

		System.out.println(userRepository.findAll());
	}
}
//flush메소드 호출 시 적용
//트랜잭션 종료될때
//JPQL쿼리 실행될때 -> 복잡한 쿼리 실행될때
