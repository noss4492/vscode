package day23;

// �ΰ��� �Ķ���Ϳ� ���ϰ��� ���� ���

interface Printable {
	void print(String msg);
//	void printAll(String msg);
}

public class LamdaEx4 {
	public static void main(String[] args) {
		Printable p;
		
		p = (String s) -> {
			System.out.println(s);
		};
		
		p.print("���� ǥ���� 1��");
		System.out.println("----------------");
		// {} ������ 1����� {} ���� ���� ����
		// ��� ���ϰ��� �������� �����Կ�
		
		p = (String s) -> System.out.println(s);
		p.print("���� ǥ���� 2��");
		System.out.println("----------------");
		
		// �Ű������� ������ �־ Ÿ���� ����(�߷�) �� �� �ִ�.
		// �ڷ����� ���� ����
		p = (s) -> System.out.println(s);
		p.print("���� ǥ���� 3��");
		System.out.println("----------------");
		
		// �Ű������� 1���� �����Ѵٸ� () ���� �� �� ����
		p = s -> System.out.println(s);
		p.print("���� ǥ���� 4��");
		System.out.println("----------------");
		
		
	}
}
