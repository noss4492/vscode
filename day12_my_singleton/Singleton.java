package day12_my_singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();
	// new �����ڷ� �ν��Ͻ� ������ �Ұ��������� T.T
	// �׷��� ������ �������� �̱��� Ŭ���� ��ü�� ������.
	private Singleton() {	// private ������(���� Ư���ѵ�?) -> new ������ X 
		System.out.println("Singleton Instance Created.. ");
	}
	public static Singleton getInstance() {
		return singleton;
	}
}
