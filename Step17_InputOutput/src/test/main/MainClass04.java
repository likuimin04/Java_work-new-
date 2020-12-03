package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		// 콘솔창에 출력 할 수 있는 객체의 참조값을 ps라는 지역 변수에 담기
		PrintStream ps=System.out;
		// 학습을 위해서 PrintStream 객체를 부모 type outputStream 변수에 담기
		OutputStream os=ps;
		try {
			os.write(65);
			os.write(66);
			os.write(67);
			os.flush();  //.flush() 하는 시점에 출력된다.
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("main 메소드가 종료됩니다.");
	}
}
