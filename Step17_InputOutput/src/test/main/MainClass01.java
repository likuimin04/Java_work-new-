package test.main;

import java.io.IOException;
import java.io.InputStream;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다.");
		// 키보드로 부터 입력 받을수 있는 객체 참조값을 kbd 라는 이름의 지역 변수에 담기
		InputStream kbd=System.in;
		try {
			System.out.print("문자1개 입력: ");  //여기서 "println"이 아닌 ""print" 사용하면 같은 위치에 2를 사용 할 수 있다.
			int code=kbd.read();
			// 입력 받은 코드 값을 출력하기
			System.out.println("code: "+code);
			// 코드에 대응되는 문자 1개 얻어내는 방법
			char ch=(char)code;
			System.out.println("ch: "+ch);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
