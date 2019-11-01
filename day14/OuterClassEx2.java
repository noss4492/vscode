package day14;

public class OuterClassEx2 {
	private int a = 10;
	static int b = 20;
	static final int c = 30;
	
	static class InnerClass2{	// 위 outerclass 인스턴스화 하지 않아도 호출 가능.
		int d = 40;
		static int e = 50;
		static final int F = 60;
		void print() {
//			System.out.println("a : "+a);
			System.out.println("b : "+b);
			System.out.println("c : "+c);
			System.out.println("d : "+d);
			System.out.println("e : "+e);
			System.out.println("F : "+F);
		}// print end
	}
	public static void main(String[] args) {
		System.out.println(OuterClassEx2.b);
		
		InnerClass2 ic2 = new InnerClass2();
		
	}
}
