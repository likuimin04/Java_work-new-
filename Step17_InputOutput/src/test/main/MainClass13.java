package test.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * 	c:/myFolder/memo.txt 파일에 저장된 문자열을 읽어와서
		 * 	콘솔창에 출력하는 코드를 작성해 보세요.
		 * 
		 * hint! -> new FileReader()
		 */
		File f=new File("c:/myFolder/memo.txt");
		try {
			FileReader fr=new FileReader(f);
			// 아래 세줄의 코드를 무한 루프 돌면서 수행하다가
			// read() 메소드 -1 을 리턴하면 루프를 탈출하기
			while(true) {  // while 문을 사용한다 while문은 true가 되면 무한 루프가 되고 false가 되면 바로 빠져나가게 된다.
				int code=fr.read();
				// 만일 code 가 -1 과 같으면 반복문 while 을 탈출 하세요
				if(code==-1) {
					//break 예약어는 반복문을 탈출하는 예약어이다.
					break;
				}
				//code 에 해당하는 문자 값을 얻어내서
				char ch=(char)code;
				// 개행 기호 없이 출력
				System.out.println(ch);
			}	
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
