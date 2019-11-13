package day23;
// �׷��ٸ� Merge �������̽��� ó������ ���ٽ��� �� �� �ִ� �������̽�
// ��� ���� ó�� ���� ������ �� ������?
@FunctionalInterface //����� �������̽�(Ư���� ����� �ϴ� �������̽�)
interface Merge {
	public int add(int a, int b);
	// ���ٽ��� ���� �������̽����� �߻� �޼��� �� �ϳ����� �Ѵ�.
}

public class LamdaEx5 {
	public static void main(String[] args) {
		Merge m;
		
		//1
		m = new Merge() {
			@Override
			public int add(int a, int b) {
				return a+b;
			}
		};
		//2
		m = (a, b) -> {return a + b;};
		//3
		m = (a, b) -> a+b;

		
		System.out.println(m.add(100, 200));

	}
}
