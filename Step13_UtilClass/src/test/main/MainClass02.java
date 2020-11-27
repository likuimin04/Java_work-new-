package test.main;

import java.util.HashMap;

public class MainClass02 {
	public static void main(String[] args) {
		// 한명의 회원 정보라고 가정하자.
		int num=1;
		String name="김구라";
		String addr="노량진";
		boolean isMan=true;
		
		// 동일한 회원 정보를 HashMap 객체를 생성해서 담을수도 있다.
		HashMap<String, Object> map1=new HashMap<String, Object>();
		map1.put("num", num);
		map1.put("name",name);
		map1.put("addr",addr);
		map1.put("isMan",isMan);
		
		//map1 을 이용해서 번호 "num" 이라는 키값으로 저장된 int 불러오기
		int a= (int)map1.get("num");
		String b=(String)map1.get("name");
		String c=(String)map1.get("addr");
		boolean d=(boolean)map1.get("isMan");
		
	}
}
