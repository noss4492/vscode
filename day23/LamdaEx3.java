package day23;

// �ΰ��� �Ķ���Ϳ� ���ϰ��� ���� ���

interface Calculator3 {
	void cal(int a, int b);
}

public class LamdaEx3 {
	public static void main(String[] args) {
		Calculator3 c3;
		c3 = (a, b) -> {System.out.println("-------");
						System.out.println((a+b));};	
		c3.cal(4, 3);
		System.out.println("c3:"+c3);

		
		// �����̸� brace ���� ����
		c3 = (a, b) -> System.out.println((a-b));
		c3.cal(4, 3);
		System.out.println("c3:"+c3);
	}
}
