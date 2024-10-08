package com.abc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.blog.controller.dto.ResponseDto;
import com.abc.blog.model.RoleType;
import com.abc.blog.model.User;
import com.abc.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class UserApiController {
	@Autowired
	private UserService userService;	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) {
		System.out.println("UserApiController: save 호출됨");
		userService.회원가입(user);
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1);
	}
//	@PostMapping("/api/user/login")
//	public ResponseDto<Integer> login(@RequestBody User user, HttpSession session) {
//		System.out.println("UserApiController: login 호출됨");
//		User principal = userService.로그인(user); // principal: 접근주체
//		if (principal != null) {
//			session.setAttribute("principal", principal); // 세션 생성
//		}
//		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1);
//	}
}
