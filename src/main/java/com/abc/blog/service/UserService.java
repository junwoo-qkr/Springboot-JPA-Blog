package com.abc.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abc.blog.model.User;
import com.abc.blog.repository.UserRepository;

@Service // 스프링이 컴포넌트 스캔하여 Bean에 등록을 해줌
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional 
	public void 회원가입(User user) {
		userRepository.save(user);
	}
	
	@Transactional(readOnly = true) // select할 때 트랜잭션 시작, 서비스 종료 시에 트랜잭션 종료 -> 정합성 유지
	public User 로그인(User user) {
		return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
	}
}