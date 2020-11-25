package GundamInfo;

public class F91_Gundam {
	public void on() {
		System.out.println("F91 Gundam System [ On ]");
	}
	public void go() {
		System.out.println("F91 Gundam 출발하겠습니다.");
	}
	public void move() {
		System.out.println("F91 이 움직인다.");
	}
	public void attack() {
		System.out.println("F91 이 적에게 공격을 시전한다.");
	}
	public void weapon() {  // 웨폰을 배열로 정리해보자.
		System.out.println("F91 무장 [Info]");
		System.out.println("-----무장 정보-----");
		System.out.println("무장1: 빔사벨 x2");
		System.out.println("무장2: 빔 라이플");
		System.out.println("무장3: 베스바");
		System.out.println("무장4: 헤드 발칸");
		System.out.println("----------------");
	}
	public void fly() {
		System.out.println("F91 이 부스터를 사용하였다.");
	}
	public void foOn() {
		System.out.println("F91 이 리미터를 해제 [Face Open Mode] 'On' 하였습니다.");
	}
	public void foOff() {
		System.out.println("F91 이 리미터를 해제 [Face Open Mode] 'Off' 하였습니다.");
	}
	public void back() {
		System.out.println("F91 이 전함으로 돌아온다.");
	}
	public void off() {
		System.out.println("F91 Gundam Syetem [ Off ]");
	}
}