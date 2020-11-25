package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass06 {
	// 실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		//usePhone()메소드를 호출하는 코드를 아래에 작성해 보세요.
		MainClass06.usePhone(new Phone()); // 이유 스택틱 메소드를 호출 할려면 "."을 찍어서 호출해야한다.
		MainClass06.usePhone(new HandPhone());
		MainClass06.usePhone(new SmartPhone());
	}
	
	// Phone type 을 인자로 전달 받는 static 메소드
	public static void usePhone(Phone p) {
		// 인자로 전달 되는 참조값을 이용해서 메소드 호출하기
		p.call();
	}
}
