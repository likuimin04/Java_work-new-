package test.main;

import test.mypac.MyUtil;

public class MainClass08 {
	public static void main(String[] args) {
		MyUtil.draw();
		try {
			MyUtil.send();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
