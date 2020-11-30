package test.main;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
/*
 *  HashSet 클래스는 Set 인터페이스를 구현한 클래스이다.
 *  - 저장된 데이터를 순서없이 무작위로 관리한다.
 *  - key 값도 없다.
 *  - 중복을 허용하지 않는다 ( 같은 값이 두개 이상 존재 할 수 없다)
 *  - 어떤 data 를 묶음 (집합) 으로 관리 하고자 할 때 사용한다.
 *  - 중복된 데이터를 제거 할 때도 유용하다.
 */

public class MainClass09 {
	public static void main(String[] args) {
		
		Set<Integer>set1=new HashSet<Integer>();
		set1.add(10);
		set1.add(20);
		set1.add(20);
		set1.add(30);
		set1.add(30);
		// 어떤 data가 Set 에 있는지 여부를 리턴 하는 메소드
		boolean result1=set1.contains(10); //true
		boolean result2=set1.contains(50); //false
		// Set 가 비어 있는지 여부를 리턴
		boolean result3=set1.isEmpty(); //false
		// 저장된 아이템의 갯수
		int size=set1.size(); // 3 (아이템이 중복이 안됨으로 3개)
		
		// 정수가 일렬로 담겨진 Intertor 객체의 참조값 얻어내기
		Iterator<Integer> it=set1.iterator();
		//커서 다음에 데이터가 있으면
		while(it.hasNext()) {
			// 커서를 다음 데이터로 옴겨서 해당 데이터를 읽어낸다.
			Integer tmp=it.next();
			// 읽어낸 데이터 콘솔에 출력하기
			System.out.println(tmp);
		}
	}
}
