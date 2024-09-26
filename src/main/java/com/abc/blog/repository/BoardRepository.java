package com.abc.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.blog.model.Board;
import com.abc.blog.model.User;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
