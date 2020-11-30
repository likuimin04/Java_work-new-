package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  1. 3명의 회원 정보를 HashMap 객체를 3개 생성해서 각각 담아보세요.
		 *     번호 => "num" 이라는 키값 으로 정수 저장
		 *     이름 => "name" 이라는 키값으로 문자열 저장
		 *     주소 => "addr" 이라는 키값으로 문자열 저장
		 *     
		 *  2. 위에서 생성한 Map 을 담을 ArrayList 객체를 생성하고 생성된 참조값을
		 *  	members 라는 이름의 지역 변수에 담아 보세요.
		 *  
		 *  3. members 에 회원 정보가 담긴 Map 객체의 참조값을 순서대로 담아보세요.
		 *  4. 반복문 돌면서 members 에 담긴 내용을 아래와 같은 형식으로 출력해 보세요.
		 *  
		 *  번호: 1, 이름: 김구라, 주소: 노량진
		 *  번호: 2. 이름: 해골, 주소: 행신동
		 *  .
		 */
		
		// 1.
		Map<String, Object> map1=new HashMap<String, Object>();
		map1.put("num", 1);
		map1.put("name", "엑스트라1 ");
		map1.put("addr", "청담동");
		Map<String, Object> map2=new HashMap<String, Object>();
		map2.put("num", 2);
		map2.put("name", "엑스트라2 ");
		map2.put("addr", "삼성동");
		Map<String, Object> map3=new HashMap<String, Object>();
		map3.put("num", 3);
		map3.put("name", "엑스트라3 ");
		map3.put("addr", "천호동");
		
		// 2.
		List<Map<String, Object>> members=new ArrayList<>();
		
		// 3.
		members.add(map1);
		members.add(map2);
		members.add(map3);
		
		//4.
		for(Map mem:members) {
			String info="번호: "+mem.get("num")
						+"이름: "+mem.get("name")
						+"주소: "+mem.get("addr");
			System.out.println(info);
		}
		System.out.println("-----------------------------");
		// 캐스팅을 사용해서 하는 방법
		for(Map<String,Object> tmp:members) {
			int num=(int)tmp.get("num");
			String name=(String)tmp.get("name");
			String addr=(String)tmp.get("addr");
			System.out.println("번호 : "+num+", 이름 : "+name+", 주소 : "+addr);
		}
	}
}