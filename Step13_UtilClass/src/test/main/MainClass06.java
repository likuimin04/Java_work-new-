package test.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import test.mypac.MemberDto;

public class MainClass06 {
	public static void main(String[] args) {
		// MemberDto 객체의 참조값을 담을수 있는 ArrayList 객체를 생성해서
		// ArrayList 객체의 참조값을 List type 지역변수 members에 담기
		List<MemberDto> members=new ArrayList<MemberDto>();
		// 3명의 회원 정보를 members 배열에 담아 보세요
		/*
		 * 1번째 방법
		 * Setter 사용법으로 만들기
		 * MemberDto mem1=new MemberDto();
		 * mem1.setNum(1);
		 * mem1.setNum("김구라");
		 * mem1.setNum("노량진");
		 * members.add(mem1);
		 */
		
		// 2번째 방법
		MemberDto mem1= new MemberDto(1,"김구라","노량진");
		MemberDto mem2= new MemberDto(2,"해골","행신동");
		MemberDto mem3= new MemberDto(3,"원숭이","상도동");
		members.add(mem1);
		members.add(mem2);
		members.add(mem3);
		/*
		 *  3번째 방법
		 *  다이렉트로 객체 생성을 바로 members에 추가하는 방법
		 *  members.add(new MemberDto(3,"원숭이,"청담동"));
		 */
		
		/*
		 * members 에 들어 있는 참조값을 이용해서
		 * 반복문 돌면서 아래와 같은 형식으로 회원 정보를 출력해 보세요.
		 * 
		 * 번호는 1 이름 김구라 주소는 노량진
		 * 번호는 2 이름은 해골 주소는 행신동
		 * 번호는 3 이름은 원숭이 주소는 상도동
		 */
		// 1번 패턴
		for(int i=0;i<members.size();i++) {
			members.get(i);
				String info="번호는 "+members.get(i).getNum()+
				"이름은 "+members.get(i).getName()+
				"주소는 "+members.get(i).getAddr();
			System.out.println(info);
		}
		// 2번 패턴 (이 패턴을 사용하는 것을 추천)
		System.out.println("-----------------------");
		for(int i=0;i<members.size();i++) {
			MemberDto tmp=members.get(i);
			String info="번호는 "+tmp.getNum()+
				"이름은 "+tmp.getName()+
				"주소는 "+tmp.getAddr();
			System.out.println(info);
		}
		System.out.println("-----------------------");
		/*
		 *  for(int i=0;i<members.size();i++) {
		 *  MemberDto tmp=members.get(i);
		 *  }
		 */

		// 위에 for문을 줄인것 이다. 명칭은 확장 for문이라고 칭한다.
		// 사용할 때는 type을 잘 써야한다. type은 mambers's Generic Type이랑 맞아야 사용이 가능하다
		for(MemberDto tmp:members) {
			String info="번호는 "+tmp.getNum()+
					"이름은 "+tmp.getName()+
					"주소는 "+tmp.getAddr();
			System.out.println(info);
		}
	}
}
