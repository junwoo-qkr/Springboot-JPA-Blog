package com.abc.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogControllerTest {

	@GetMapping("test/hello")
	public String hello() {
		return "<h1>hello world</h1>";
	}
}
