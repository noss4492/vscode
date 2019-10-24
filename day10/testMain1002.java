package day10;

public class testMain1002 {
	public static void main(String[] args) {
//		Parent p1;
//		Child c1 = new Child();
//		p1 = c1;
		
		Parent p1 = new Child();
		// 요렇게 쓸 수 잉네
		
		Object o1 = new Parent();
		Parent o2 = new Child();
		
	}
}
