package com.abc.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.blog.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
	// select * from user where username = XXX and password = XXX;
	// 첫번째 XXX에는 username, 두번째 XXX에는 password가 들어감 -> JPA Naming query
//	User findByUsernameAndPassword(String username, String password);
	
	// @Query(value = "select * from user where username = XXX and password = XXX", nativeQuery = True)
	// User login(String username, String password);
	// 위와 동일한 작업 실시
}
