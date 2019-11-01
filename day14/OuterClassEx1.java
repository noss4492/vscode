package day14;
// �� ��øŬ����? -> ����� �����, ���� ���� ������, ��ӹ޴���(�����̺��� �ֵ��� �ȵ� ��.��)
// ����� ��� : ���� ������ �ֳ�
// ���� ���� ���� : ����
// ��� �ޱ� : ���� �ʹ� ����

/*
�� �ּ��� ������ ������
nested class (inner class)
1. Member inner Class : Member ������ ���� ����
 */

public class OuterClassEx1 {
	private int a = 10;
	static int b = 20;
	static final int c = 30;
	//����������� ����
	class InnerClass{	// test case 1 . extends OuterClassEx1
		// test case 2. innerclass�� OuterClassEx1 ���ο� ����
		// inner class�� member ������ ���� ��ġ�� ���� ����ϴ� member 
		int d = 40;
//		static int e = 50;	// �ۿ� �ִ� Ŭ������ �ν��Ͻ�ȭ �Ǳ� ������ ����ƽ ���� �Ұ�
							// �� ?
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

