package test.main;

import test.mypac.Remocon;

public class MainClass03 {
	// Remocon 인터페이스를 구현한 Inner class
	static class AirconRemocon implements Remocon{
		@Override
		public void up() {
			System.out.println("에어콘 온도를 올려요");
		}
		@Override
		public void down() {
			System.out.println("에어콘 온도를 내려요");
		}
	}
	
	public static void main(String[] args) {
		//Remocon 인터페이스를 구현한 Local Inner Class
		class TvRemocon implements Remocon{
			@Override
			public void up() {
				System.out.println("채널을 올려요");
			}
			@Override
			public void down() {
				System.out.println("채널을 내려요");
			}
		}
		//Local inneer class를 이용한 객체를 생성
		Remocon r1=new TvRemocon();
		useRemocon(r1);
		//inner class를 이용한 객체를 생성
		Remocon r2=new AirconRemocon();
		useRemocon(r2);
	}
	
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
