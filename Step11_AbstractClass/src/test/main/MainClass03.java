package test.main;

import test.mypac.Sniper;
import test.mypac.Weapon;

public class MainClass03 {
	// Inner Class (내부 클래스에 한에서
	static class AirPlane extends Weapon{
		@Override
		public void attack() {
			System.out.println("공중에서 공격을 해요");
		}
	}
	public static void main(String[] args) {
		// Local Inner Class
		class Sword extends Weapon{
			@Override
			public void attack() {
				System.out.println("칼로 공력을 해요!");
			}
			
		}
		// Sword 객체를 생성해서 참조값을 Weapon type 으로 받기 (lacal inner class방법)
		Weapon w1=new Sword();
		useWeapon(w1);
		// AirPlane 객체를 생성해서 참조값을 Weapon type 으로 받기 (inner class 방법)
		Weapon w2=new AirPlane();
		useWeapon(w2);
		// Sniper 객체를 생성해서 참조값을 Weapon type 으로 받기 (external class 방법)
		Weapon w3=new Sniper();
		useWeapon(w3);
	}
	public static void useWeapon(Weapon w) {
		w.perpare();
		w.attack();
	}
}
