package com.fastcampus.jpa.bookmanager2.service;

import com.fastcampus.jpa.bookmanager2.domain.User;
import com.fastcampus.jpa.bookmanager2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
public class UserService {
	@Autowired
	private EntityManager entityManager;
	@Autowired
	private UserRepository userRepository;

	@Transactional
	public void put(){
		User user = new User();
		user.setName("newUser");
		user.setEmail("newUser@fast.com");

//		userRepository.save(user);
		entityManager.persist(user);
//		entityManager.detach(user);

		user.setName("newUserAfterPersist");
		entityManager.merge(user);
//		entityManager.flush();
//		entityManager.clear();//변경작업 큐가 클리어

		User user1 = userRepository.findById(1L).get();
		entityManager.remove(user1);

		user1.setName("marrrrtin");
//		entityManager.merge(user1);
	}
}
