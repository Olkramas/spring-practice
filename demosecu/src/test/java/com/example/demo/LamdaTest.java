package com.example.demo;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

public class LamdaTest {
	//자바에서 화살표함수를 람다식으로 어떻게 작성하는가
	
	//@Test
	public void sort() {
		List<Integer> list = Arrays.asList(4, 5, 6, 10, 4);
		
		Collections.sort(list); //sort안에 정렬하고자 하는 list를 사용
		System.out.println(list);	//int의 경우 알아서 정리 됨.
	}
	
	@Test
	public void sampleSort() {
		List<SampleVO> list = Arrays.asList(
				new SampleVO("김길동", 10),
				new SampleVO("이동동", 14),
				new SampleVO("홍댕댕", 16)
				);
		//sort함수 내부에는 comparator를 상속받은 구현클래스를 만들어서 넣어줘야함. 기본타입은 이런거 없음.
		
		//Collections.sort(list, new SampleCompare()); 상속받아서 하기 귀찮음 그럼 익명함수로도 가능! 아래 참고
		/*익명 클래스
		Collections.sort(list, new Comparator<SampleVO>() {

			@Override
			public int compare(SampleVO o1, SampleVO o2) {
				return o1.age - o2.age;	//리턴값을 설정하면 됨.
			}});
		*/
		//람다식으로 만들기
		//익명 클래스를 람다식으로 표현할 수 있음. 재정의할 메서드가 하나일 경우에만 가능함.
		Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
				return o1.age - o2.age;
			});
		
		System.out.println(list);
	}
}

class SampleCompare implements Comparator<SampleVO> {

	@Override
	public int compare(SampleVO o1, SampleVO o2) {
		return o1.getName().compareTo(o2.getName());	//가나다 정렬
		//return o1.age - o2.age;	//날짜 정렬
	}
	
}