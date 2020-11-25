package test.mypac;

import test.auto.Car;
import test.auto.Engine;

public class SuperCar extends Car{
	// Engine type 을 전달 받는 생성자
	public SuperCar(Engine engine) {
		// 부모 생성자에 필요한 값을 전달 해주는 문법 super()
		super(engine);
	}
	//빨리 달리는 메소드
	public void driveFast() {
		if(this.engine==null) {
			
		}
		System.out.println("엄청 빨리 달려요!");
	}
}
