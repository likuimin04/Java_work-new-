package test.main;

import java.io.File;

public class MainClass09 {
	public static void main(String[] args) {
		File myFile=new File("c:/myFolder");
		if(!myFile.exists()) {
			myFile.mkdir();
			System.out.println("c:/myFolder 파일을 생성했습니다.");
		}else {
			System.out.println("c:/myFolder 이미 존재 합니다.");
		}
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
