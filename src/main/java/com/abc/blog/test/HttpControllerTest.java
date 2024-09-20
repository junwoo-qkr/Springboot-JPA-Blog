package com.abc.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController // 사용자가 요청 -> 데이터 응답
// 사용자가 요청 -> html 파일로 응답
// @Controller
public class HttpControllerTest {
	
	private static final String TAG = "HTTPControllerTest:";
	
	@GetMapping("/http/lombok")
	public String lombokTest() {
		Member m = Member.builder().username("abc").password("1234").email("email").build();
		System.out.println(TAG + "getter: " + m.getId());
		m.setId(5000);
		System.out.println(TAG + "setter: " + m.getId());
		return "lombok test";
	}
	// 인터넷 브라우저 요청은 무조건 get요청만 해야함
	@GetMapping("/http/get")
	public String getTest(Member m) {
		return "get 요청 " + m.getId() + " " + m.getUsername() + " " + m.getPassword() + " " + m.getEmail();
	}
	
	@PostMapping("/http/post") //text/plain, application/json
	public String postTest(@RequestBody Member m) {
		return "post 요청 " + m.getId() + " " + m.getUsername() + " " + m.getPassword() + " " + m.getEmail();
	}
	
	@PutMapping("/http/put")
	public String putTest() {
		return "put 요청";
	}
	
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete 요청";
	}
}
