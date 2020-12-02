package test.main;

import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("숫자 입력: ");
		// 숫자를 문자열 형식으로 입력 받는다. "10","20", "10.1","10.2"...
		String inputNum=scan.nextLine();
		try {
			// 입력한 숫자를 실제 숫자로 바꾸기
			double num=Double.parseDouble(inputNum);
			double reuslt=num+100;
			System.out.println("입력한 숫자+100 : "+reuslt);
		}catch(NumberFormatException nfe) {
			// NumberFormatException type 의 예외가 발생하면 여기가 실행 된다.
			System.out.println("숫자 형식에 맞게 입력하세요!");
			// 예외 객체의 메소드를 이용해서 stack 에 일어난 일을 콘솔에 출력하기 (자바에서 에러가 난 이유를 보여준다)
			nfe.printStackTrace();
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
