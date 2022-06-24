package com.fastcampus.jpa.bookmanager2.domain.listener;

import com.fastcampus.jpa.bookmanager2.domain.User;
import com.fastcampus.jpa.bookmanager2.domain.UserHistory;
import com.fastcampus.jpa.bookmanager2.repository.UserHistoryRepository;
import com.fastcampus.jpa.bookmanager2.support.BeanUtils;
import org.springframework.stereotype.Component;

import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class UserEntityListener {
	@PostPersist
	@PostUpdate
	public void prePersistAndPreUpdate(Object o) {
		UserHistoryRepository userHistoryRepository = BeanUtils.getBean(UserHistoryRepository.class);
		User user = (User) o;
		UserHistory userHistory = new UserHistory();
//		userHistory.setUserId(user.getId());
		userHistory.setName(user.getName());
		userHistory.setEmail(user.getEmail());
		userHistory.setUser(user);

		userHistoryRepository.save(userHistory);
	}
}
