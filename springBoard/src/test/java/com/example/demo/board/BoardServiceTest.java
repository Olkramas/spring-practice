package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.service.BoardDTO;
import com.example.demo.board.service.BoardSearchDTO;
import com.example.demo.board.service.BoardService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
	
	@Autowired BoardService boardService;
	
	
	@DisplayName("게시글 수정")
	public void update() {
		//given
		BoardDTO board = BoardDTO.builder()
								 .bno(4L)
								 .title("서비스수정")
								 .content("내용 수정")
								 .writer("user00")
								 .build();
		//when
		boolean result = boardService.modify(board);
		
		//then
		assertThat(result).isEqualTo(true);
				
	}
	
	
	@DisplayName("게시글 등록")
	public void register() {
		//given
		BoardDTO board = BoardDTO.builder()
								 .title("안녕안녕")
								 .content("안녕 나는 태백")
								 .writer("나는태백")
								 .build();
		
		//when
		boolean result = boardService.register(board);
		
		//then
		assertThat(result).isEqualTo(true);
	}
	
	
	@DisplayName("게시글 삭제")
	public void delete() {
		long bno = 2L;
		
		
	}
	
	
	@DisplayName("단건")
	public void get() {
		
	}
	
	@Test
	@DisplayName("게시글 조회")
	public void getList() {
		BoardSearchDTO search = new BoardSearchDTO();
		search.setStart(1);
		search.setEnd(10);
		List<BoardDTO> list = boardService.getList(search);
		
		log.info(list.toString());
	}
}
