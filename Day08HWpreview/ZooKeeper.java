package Day08HWpreview;

public class ZooKeeper {
//	public static void feed(Tiger t) {
//		System.out.println("feed poo");
//	}
//	public static void feed(Lion l) {
//		System.out.println("feed won");
//	}
	// ���ο� �����ڵ��� �߰��� �� ���� �̷��� feed�� ��� �߰�������ϴ� �������� ����.
	// �׷��� ���� ���� �������̽��̴�.
// �������̽��� ���� �� (���� implements Pradator�Ͽ��� �������̽� Pradator�� �߰��Ͽ���)
	
	/*
	public static void feed(Predator p) {
		System.out.println("feed meat");
	}*/
	
	// ÷�� ���鶧 Tiger Lion�� Animal Ŭ������ ��ӹ޾� ������� �ڽ� Class����.
	// ���� Tiger Lion�� Predator �������̽��� ��ü�� ���� �ȴ�.
	// �̷��� ��ü�� �� �� �̻��� �ڷ��� Ÿ���� ���� �Ǵ� Ư���� Ÿ����(polymorphism)
	
	// ���� � ���ĵ����� �߰��Ǵ� feed�޼ҵ带 �߰��ϴ� ��� �߰��ϴ� ���ĵ����� Ŭ������ Predator �������̽��� implement(�����ϴ�, ����<<)
	
	// ���������� Ŭ������ ������ �������̽��� �������� �߿� Ŭ������ �ۼ��Ͽ�����. ����ü�� ���� ����� �������� ������(�Ǵ� ���̽��� �켱������ ������)
	// �ڹ��� ��쿡�� interface�� ���߻���� �����ϱ� ������...
	
	
	//�ٽ� ����Ǿ�
	public static void feed(Predator p) {
		System.out.println("feed "+p.getFood());
	}
	
	
	public static void main(String[] args) {
		ZooKeeper zk = new ZooKeeper();
		Tiger t = new Tiger();
		Lion l = new Lion();
		
		ZooKeeper.feed(t);
		ZooKeeper.feed(l);
		
	}
	

}
