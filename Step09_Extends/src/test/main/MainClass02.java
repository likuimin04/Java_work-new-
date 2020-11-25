package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 *  [ 다형성 ]
		 *  
		 *  - 객체는 여러가지 type 을 가질수 있다.
		 *  - 상속 관계에 따라서 여러가지 type 이 된다.
		 *  - 아래 HandPhone 객체는 3가지 type 을 가진다.
		 *  - many type 정확히 이야기 하면 polye morphism이라고 한다. 
		 *    이것이 자바에 특징중 하나다
		 */
		// HandPhone 객체를 생성해서 참조값을 HandPhone type 변수에 담기.
		HandPhone p1= new HandPhone();
		// HandPhone 객체를 생성해서 참조값을 Phone type 변수에 담기.
		Phone p2=new HandPhone();
		// HandPhone 객체를 생성해서 참조값을 Object type 변수에 담기.
		Object p3=new HandPhone();
	}
}
