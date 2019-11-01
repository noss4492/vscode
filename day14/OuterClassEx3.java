package day14;

public class OuterClassEx3 {
	private int a = 10;
	static int b = 20;
	static final int c = 30;
	
	// 지역변수처럼, localinnerClass
	public void printALL() {
		class LocalInnerClass{
			int d = 40;
			static final int F = 60;
			void print() {
				System.out.println("a : "+a);
				System.out.println("b : "+b);
				System.out.println("c : "+c);
				System.out.println("d : "+d);
				System.out.println("F : "+F);
			}
		}
		
		LocalInnerClass lic = new LocalInnerClass();
		lic.print();
	}// printall end()
	public static void main(String[] args) {
		OuterClassEx3 oce3 = new OuterClassEx3();
		oce3.printALL();
	}
}//
