package com.example.demo.reply.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.reply.service.ReplyDTO;
import com.example.demo.reply.service.ReplyPageDTO;
import com.example.demo.reply.service.ReplySearchDTO;
import com.example.demo.reply.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@AllArgsConstructor
public class ReplyController {
	private ReplyService replyService;
	
	//등록
	@PostMapping("/reply/new")
	public String addReply(@RequestBody ReplyDTO reply) {
		replyService.addReply(reply);
		return "success";
	}
	
	//수정
	@PutMapping("/reply")
	public String modifyReply(@RequestBody ReplyDTO reply) {
		log.info("reply: " + reply.toString());
		replyService.modifyReply(reply);
		return "success";
	}
	
	/*
	//삭제 
	@DeleteMapping("/reply/{rno}")
	public int removeReply(@PathVariable long rno) {
		return replyService.removeReply(rno);
	} 
	*/
	//삭제 교수님 해설
	@DeleteMapping("/reply/{rno}")
	public String remove(@PathVariable(name="rno") Long rno) {
		replyService.removeReply(rno);
		return "success";
	}
	
	//조회
//	@GetMapping("/list")
//	public List<ReplyDTO> getList(@RequestParam(name="bno") Long bno) {
//		
//		List<ReplyDTO> list = replyService.getList(null, bno);
//		return list;
//	}
	
	//조회
	@GetMapping("/reply/pages/{bno}/{page}") 
	public ReplyPageDTO getList(@PathVariable(name="page") int page,
								  @PathVariable(name="bno") Long bno){
		
		ReplySearchDTO replySearchDto = new ReplySearchDTO(page, 3);
		
		return replyService.getList(replySearchDto, bno);
	}
	
	/*
	//교수님 댓글 목록 조회
	@GetMapping("/pages/{bno}/{page}")
	public ReplyPageDTO getList(@PathVariable(name="page") int page,
								@PathVariable(name="bno") Long bno) {
		ReplySearchDTO replySearchDTO = new ReplySearchDTO(page, 10);
		return replyService.getList(replySearchDTO, bno);
	}
	*/
}
