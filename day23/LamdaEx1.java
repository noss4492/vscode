package day23;
// ���ٽ� ==> �޼���(�Լ�)�� �ϳ��� ������ ǥ���� ��



interface Oper{
	public int addOne(int a);
}

public class LamdaEx1 {
	// �׸����ϴ� ���ӽ� ����..
	// �͸� ��ø Ŭ���� -> �����ϰ� ǥ�� ����
	public static void main(String[] args) {
		Oper add = new Oper() {
			@Override
			public int addOne(int a) {
				return ++a;
			}
		};	//�͸� inner Class
		
		System.out.println(add.addOne(10));
		System.out.println("--------------------------");
		
		Oper add2 = (a) -> ++a;
		System.out.println(add2.addOne(10));
		System.out.println("--------------------------");
		
	}
}
