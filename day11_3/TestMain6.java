package day11_3;

public class TestMain6 {
	static int no;
	int no2;
	
	static {	// static block
		int a =10;
		System.out.println("a : "+a);
	}
	TestMain6(){
		System.out.println("�⺻������");
	}
	public static void show() {
		System.out.println("static method show()");
	}
	public void show2() {
		System.out.println("instance method show2()");
	}
	
}
