package com.example.demo.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ObjectMapperTest {
	@Test
	public void test() throws JsonMappingException, JsonProcessingException {
		// string => vo로 바꾸기
		String str = """
						{"name":"홍","age":20}
					 """;
		ObjectMapper om = new ObjectMapper();
		//readValue로 String을 객체로 만ㄷ름
		MemVo vo = om.readValue(str, MemVo.class);
		assertThat(vo.getName()).isEqualTo("홍");
		log.info("vo: " + vo.toString());
		
		//vo를 String으로 바꾸기
		String data = om.writeValueAsString(vo);	//객체를 넣으면 String으로 파싱됨.
		log.info("data: " + data);
	}
}
