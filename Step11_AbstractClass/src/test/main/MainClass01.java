package test.main;

import test.mypac.MyWeapon;
import test.mypac.Weapon;

public class MainClass01 {
	public static void main(String[] args) {
		// 추상클래스 단독으로는 객체 생성 불가
		 Weapon w= new MyWeapon();
		 w.perpare();
		 w.attack();
	}
}
