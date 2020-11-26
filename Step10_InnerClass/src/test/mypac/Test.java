package test.mypac;
/*
 *  클래스안에 정의 할 수 있는 맴버?
 *  1. 생성자
 *  2. 필드
 *  3. 메소드
 *  4. 클래스
 */
public class Test {
	// 클래스 안에 정의 하는 클래스는 inner class 라고 한다.
	public class a{
		
	}
	public class b{
		
	}
	/*
	 * 메소드 안에서 정의 할 수 있는것?
	 *  1. 지역 변수 (Local Variable)
	 *  2. 지역 내부 클래스(local Inner Class)
	 */
	public void test1() {
		class C{
			public void merong() {
				System.out.println("복잡하지롱~");
			}
		}
		C a=new C();
		a.merong();
	}
}
