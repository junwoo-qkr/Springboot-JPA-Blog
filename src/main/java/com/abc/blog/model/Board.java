package com.abc.blog.model;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content;
	
	@ColumnDefault("0")
	private int count;
	
	@ManyToOne // Many = Board, One = user -> 한명의 유저가 여러 게시글 작성 가능
	@JoinColumn(name = "userId")
	private User user; // ORM을 사용하면 DB에 오브젝트 저장 가능
	
	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER) // 연관관계의 주인이 아님(FK가 아님) -> DB에 column 생성 X
	private List<Reply> reply;
	
	@CreationTimestamp
	private Timestamp createDate;
}
