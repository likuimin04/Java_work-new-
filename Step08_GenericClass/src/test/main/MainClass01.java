package test.main;

import test.mypac.FruitBox;
import test.mypac.Orange;
import test.mypac.Apple;
import test.mypac.Banana;

public class MainClass01 {
	public static void main(String[] args) {
		FruitBox<Apple> box1=new FruitBox<Apple>();
		FruitBox<Banana> box2=new FruitBox<Banana>();
		FruitBox<Orange> box3=new FruitBox<Orange>();
		
		//setItem() 메소드에 전달해야하는 type 이 Genaric Class에 의해서 정해진다.
		box1.setItem(new Apple());
		box2.setItem(new Banana());
		box3.setItem(new Orange());
		
		//필드의 data type 이 Generic class 에 의해서 정해진다.
		Apple a= box1.item;
		Banana b= box2.item;
		Orange c= box3.item;
	}
}
