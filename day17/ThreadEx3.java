package day17;

// 1. Runnable interface ����
// 2. run() override
// 3. �� ��ü�� ����
// 4. Thread Ŭ������ �����ڿ� �ֱ�
// 5. Thread Ŭ���� ��ü�� ���ؼ� start() ȣ��

public class ThreadEx3 implements Runnable {
	String name;

	public ThreadEx3(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(name+" : "+i+" ���� �޸��� ��");
		}
	}
	
	public static void main(String[] args) {
		ThreadEx3 r1 = new ThreadEx3("�䳢��");
		ThreadEx3 r2 = new ThreadEx3("�ź���");

		Thread th1 = new Thread(r1);
		Thread th2 = new Thread(r2);
		
		
		th1.start();
		th2.start();
		
		System.out.println(th1.getId()+th1.getName()+th1.getClass());
		System.out.println(th1.getStackTrace());
		System.out.println("-----------------------");
//		th1.run();
//		th2.run();
		
	}
}
