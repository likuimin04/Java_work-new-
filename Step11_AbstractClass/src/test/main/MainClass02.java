package test.main;

import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 여러분이 직접 Weapon 추상 클래스를 상속받은 클래스를
		 * 정의해서 객체 생성을 하고 해당 참조값을 이용해서
		 * 아래의 useWeapon 매소드를 호출해 보세요.
		 * (단, 클래스명은 MyWeapon 말고 다른걸로)
		 */
		public class Sniper extends Weapon{
			@Override
			public void attack() {
				Sniper sp=new Sniper;
				sp.perpare();
				sp.attack();	
			}
		}
	}
	public static void useWeapon(Weapon w) {
		w.perpare();
		w.attack();
	}
}
