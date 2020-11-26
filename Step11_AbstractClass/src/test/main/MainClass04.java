package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	public static void main(String[] args) {
		Weapon w1=new Weapon() {
			@Override
			public void attack() {
				System.out.println("아무거나 공격해요!");
			}
		};
		useWeapon(w1);
		useWeapon(w1);
	}
	
	public static void useWeapon(Weapon w) {
		w.perpare();
		w.attack();
	}
}
