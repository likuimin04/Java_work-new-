package test.main;

import test.war.Marine;
import test.war.Pentagon;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 *  [ 프로그래밍의 목적 ]
		 *  
		 *  1. 사령부에서 전쟁을 선언하고
		 *  2. 마린을 움직여서
		 *  3. 마린으로 공격하고
		 *  4. 사령부에서 전쟁을 종료 
		 */
		//1.
		Pentagon.startWar();
		//2. 3. 
		Marine m1=new Marine();
		m1.move();
		m1.attack();
		//4. 
		Pentagon.endWar();
		/*
		 *  이런 작업을 할때는 이런 클래스의 이런 메소드를 활용하고
		 *  저런 작업을 할때는 이런 객체의 이런 메소드를 활용하고
		 *  어떤 값이 필요 할때는 이런 객체의 이런 필드를 참조하고...
		 */
	}
}



