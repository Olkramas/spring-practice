package com.example.demo.board;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mappers.BoardMapper;
import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardMapperTest {
	
	@Autowired BoardMapper boardMapper;
	
	/*
	 	1. given: 어떤 상황이 주어졌을 때(이 데이터 기반으로 함)

		2. when: ~를 실행했을 때(검증할 것을 실행)
		
		3. then: 검증한 결과가 ~가 나와야함
	 */
	@DisplayName("게시글 등록")
	public void testInsertBoard() {
		//given
		BoardDTO board = BoardDTO.builder().title("새로운 등록1")
							               .content("내용")
							               .writer("작성자 1")
							               .build();
		
		//when
		int cnt = boardMapper.insertBoard(board);
		
		//then
		assertThat(cnt).isEqualTo(1);
	}
	

	@DisplayName("게시글 수정")
	public void testUpdateBoard() {
		BoardDTO board = BoardDTO.builder().title("새로운 등록1")
				   .bno(5L)
	               .content("수정된 내용")
	               .writer("수정된 작성자")
	               .build();
		
		int cnt = boardMapper.updateBoard(board);
		assertThat(cnt).isEqualTo(1);
	}
	

	@DisplayName("게시글 삭제")
	public void testDelete() {
		int cnt = boardMapper.deleteBoard(1L);
		
		assertThat(cnt).isEqualTo(1);
	}
	

	@DisplayName("게시글 상세조회")
	public void testInfo() {
		long bno = 2L;
		
		BoardDTO board = boardMapper.info(bno);
		
		log.info(board.toString());
		
		//board가 null이 아닌 경우 ok
		assertThat(board).isNotNull();
	}
	
	@Test
	@DisplayName("게시글 전체조회")
	public void testFindAll() {
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		
		List<BoardDTO> list = boardMapper.findAll(search);
		
		log.info(list.toString());
		
		assertThat(list).isNotNull();
				
	}
	
}
