package com.fastcampus.jpa.bookmanager2.repository;

import com.fastcampus.jpa.bookmanager2.domain.Gender;
import com.fastcampus.jpa.bookmanager2.domain.User;
import com.fastcampus.jpa.bookmanager2.domain.UserHistory;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
class UserRepositoryTest {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserHistoryRepository userHistoryRepository;

	@Test
	void crud() {
//		userRepository.save(new User());
//		userRepository.findAll().forEach(System.out::println);
	}

	@Test
	void crud2() {
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
	void crud3() {
//		User user = userRepository.getOne(1L);
//		Optional<User> user = userRepository.findById(1L);
		User user = userRepository.findById(1L).orElse(null);
		System.out.println(user);
	}

	@Test
	void crud4() {
		userRepository.save(new User("new martin", "newmartin@slow.com"));
		userRepository.flush();
		userRepository.findAll().forEach(System.out::println);
	}

	@Test
	void select() {
		System.out.println(userRepository.findByName("martin"));

		System.out.println("findByEmail : " + userRepository.findByEmail("martin@faset.com"));
		System.out.println("getByEmail : " + userRepository.getByEmail("martin@faset.com"));
		System.out.println("readByEmail : " + userRepository.readByEmail("martin@faset.com"));
		System.out.println("queryByEmail : " + userRepository.queryByEmail("martin@faset.com"));
		System.out.println("searchByEmail : " + userRepository.searchByEmail("martin@faset.com"));
		System.out.println("streamByEmail : " + userRepository.streamByEmail("martin@faset.com"));
		System.out.println("findUserByEmail : " + userRepository.findUserByEmail("martin@faset.com"));
		System.out.println("findSomethingByEmail : " + userRepository.findSomethingByEmail("martin@faset.com"));

//		System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
		System.out.println("findFirst1ByName : " + userRepository.findFirst1ByName("martin"));
		System.out.println("findTop2ByName : " + userRepository.findTop2ByName("martin"));
		System.out.println("findFirst2ByName : " + userRepository.findFirst2ByName("martin"));

//		System.out.println("findLast1ByName : " + userRepository.findLast1ByName("martin"));
		System.out.println("findByEmailAndName : " + userRepository.findByEmailAndName("martin@faset.com", "martin"));
		System.out.println("findByEmailOrName : " + userRepository.findByEmailOrName("martin@faset.com", "denis"));
		System.out.println("findByCreatedAtAfter : " + userRepository.findByCreatedAtAfter(LocalDateTime.now().minusDays(1L)));
		System.out.println("findByIdAfter : " + userRepository.findByIdAfter(4L));
		System.out.println("findByCreatedAtGreaterThan : " + userRepository.findByCreatedAtGreaterThan(LocalDateTime.now().minusDays(1L)));
		System.out.println("findByCreatedAtGreaterThanEqual : " + userRepository.findByCreatedAtGreaterThanEqual(LocalDateTime.now().minusDays(1L)));
		System.out.println("findByCreatedAtBetween : " + userRepository.findByCreatedAtBetween(LocalDateTime.now().minusDays(1L), LocalDateTime.now().plusDays(1L)));
		System.out.println("findByIdBetween : " + userRepository.findByIdBetween(1L, 3L));

		System.out.println("findByIdIsNotNull : " + userRepository.findByIdIsNotNull());
//		System.out.println("findByAddressIsNotEmpty : " + userRepository.findByAddressIsNotEmpty());
		System.out.println("findByNameIn : " + userRepository.findByNameIn(Lists.newArrayList("martin", "denis")));


		System.out.println("findByNameStartingWith : " + userRepository.findByNameStartingWith("mar"));
		System.out.println("findByNameEndingWith : " + userRepository.findByNameEndingWith("tin"));
		System.out.println("findByNameContains : " + userRepository.findByNameContains("rt"));
		System.out.println("findByNameLike : " + userRepository.findByNameLike("%art%"));

	}

	@Test
	void pagingAndSortingTest() {
		System.out.println("findTop1ByName : " + userRepository.findTop1ByName("martin"));
		System.out.println("findTopByNameOrderByIdDesc : " + userRepository.findTopByNameOrderByIdDesc("martin"));
		System.out.println("findFirstByNameOrderByIdDescEmailAsc : " + userRepository.findFirstByNameOrderByIdDescEmailAsc("martin"));
		System.out.println("findFirstByNameWithSortParams : " + userRepository.findFirstByName("martin", Sort.by(Sort.Order.desc("id"), Sort.Order.asc("email"))));
		System.out.println("findFirstByNameWithPaging : " + userRepository.findByName("martin", PageRequest.of(0, 1, Sort.by(Sort.Order.desc("id")))).getContent());
	}

	@Test
	void insertAndUpdateTest() {
		User user = new User();
		user.setName("martin");
		user.setEmail("martin2Wfast.com");
		userRepository.save(user);
		User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
		user2.setName("2222");
		userRepository.save(user2);
	}

	@Test
	void enumTest() {
		User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
//		user.setGender(Gender.MALE);

		userRepository.save(user);

		System.out.println(userRepository.findRawRecord());


		System.out.println(userRepository.findRawRecord());
	}

	@Test
	void listenerTest() {
		User user = new User();
		user.setEmail("martin2@fastcampus.com");
		user.setName("martin");
		userRepository.save(user);

		User user2 = userRepository.findById(1L).orElseThrow(RuntimeException::new);
		user2.setName("marrrtin");

		userRepository.save(user2);
		userRepository.deleteById(4L);
	}

	@Test
	void prePersistTest() {
		User user = new User();
		user.setEmail("martin2@fastcampus.com");
		user.setName("martin");
//		user.setCreatedAt(LocalDateTime.now());
//		user.setUpdatedAt(LocalDateTime.now());

		userRepository.save(user);
		System.out.println(userRepository.findByEmail("martin2@fastcampus.com"));
	}

	@Test
	void preUpdateTest() {
		User user = userRepository.findById(1L).orElseThrow(RuntimeException::new);
		System.out.println("as-is : " + user);

		user.setName("martin");
		//바뀐게 없다면 ? -> save가안되면서 실행안됨
		userRepository.save(user);

		System.out.println("to-be: " + userRepository.findAll().get(0));

	}

	@Test
	void userHistoryTest() {
		User user = new User();
		user.setEmail("martin-new@fastcampus.com");
		user.setName("martin-new");

		userRepository.save(user);

		user.setName("martin-new-new");

		userRepository.save(user);

		userHistoryRepository.findAll().forEach(System.out::println);
	}

	@Test
	void userRelationTest() {
		User user = new User();
		user.setName("david");
		user.setEmail("david@fc.com");
		user.setGender(Gender.MALE);

		userRepository.save(user);

		user.setName("daniel");
		userRepository.save(user);
		user.setEmail("daniel@fc.com");
		userRepository.save(user);

//		userHistoryRepository.findAll().forEach(System.out::println);
//		List<UserHistory> result = userHistoryRepository.findByUserId(
//				userRepository.findByEmail("daniel@fc.com")
//						.getId()
//		);
		List<UserHistory> result = userRepository.findByEmail("daniel@fc.com")
				.getUserHistories();
		result.forEach(System.out::println);
	}
}
