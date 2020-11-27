package test.main;

import test.mypac.Drill;

public class MainClass05 {
	public static void main(String[] args) {
		// 인터페이스에 메소드를 하나 만들고 이 방법으로 또하나의 메소드를 추가하는 방법
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 3개 뚫어요");
			}
		});
		// 메소드가 오직 하나인 경우에만 사용이 가능하다.
		// 위에 익명에 클래스를 축소한 예약어이다.
		useDrill(()->{
			System.out.println("천장에 구멍을 2개 뚫어요");
		});
		
		Drill d1=()->{
			System.out.println("아무데나 구멍을 뚫어요");
		};
		useDrill(d1);
	}

	public static void useDrill(Drill d) {
		d.hole();
	}
}
