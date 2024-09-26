package com.abc.blog.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.blog.config.auth.PrincipalDetail;
import com.abc.blog.controller.dto.ResponseDto;
import com.abc.blog.model.Board;
import com.abc.blog.model.RoleType;
import com.abc.blog.model.User;
import com.abc.blog.service.BoardService;
import com.abc.blog.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
public class BoardApiController {
	
	@Autowired
	private BoardService boardService;
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) {
		boardService.글쓰기(board, principal.getUser());
		return new ResponseDto<Integer> (HttpStatus.OK.value(), 1);
	}
}
