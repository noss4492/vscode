package day14;
// 왜 중첩클래스? -> 멤버로 삼던가, 뉴로 만들어서 쓰던가, 상속받던가(프라이빗한 애들은 안되 ㅠ.ㅠ)
// 멤버로 삼기 : ㅇㅎ 이점이 있네
// 뉴로 만들어서 쓰기 : 귀찮
// 상속 받기 : 둘이 너무 붙음

/*
이 주석은 선생님 정리임
nested class (inner class)
1. Member inner Class : Member 변수와 같은 역할
 */

public class OuterClassEx1 {
	private int a = 10;
	static int b = 20;
	static final int c = 30;
	//멤버변수같은 역할
	class InnerClass{	// test case 1 . extends OuterClassEx1
		// test case 2. innerclass를 OuterClassEx1 내부에 포함
		// inner class를 member 변수와 같은 위치에 놓고 사용하는 member 
		int d = 40;
//		static int e = 50;	// 밖에 있는 클래스가 인스턴스화 되기 전에는 스태틱 선언 불가
							// 왜 ?
		static final int F = 60;
		void print() {
			System.out.println("a : "+a);
			System.out.println("b : "+b);
			System.out.println("c : "+c);
			System.out.println("d : "+d);
//			System.out.println("e : "+e);
			System.out.println("F : "+F);
		}// print end
	}//innerClass end
	public static void main(String[] args) {
		System.out.println(OuterClassEx1.b);
		OuterClassEx1 oce = new OuterClassEx1();
		System.out.println(oce.a);
		
		OuterClassEx1.InnerClass ic = oce.new InnerClass();
		System.out.println(ic.d);
		ic.print();
//		InnerClass ic = new InnerClass();
//		ic.print();
	} // main method end
} // OuterClass End

