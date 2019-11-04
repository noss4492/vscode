package day17;
/*
1. Thread ���
2. run() override
3. start() : ����
 */

public class ThreadEx2 extends Thread {
	ThreadEx2(String name) {
		super(name);
		// String ���ڸ� �޴� �����ڸ� ȣ��
		// �̸� �޾Ƽ� ������ �̸�����

	}

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			long start = System.nanoTime();
			System.out.print(Thread.currentThread().getName() + " : " + i + "m");
			long end = System.nanoTime();
			System.out.println(" " + Math.abs(start - end) + "ns");
			try {
				Thread.sleep((long) (Math.random()*200));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}// run end

	public static void main(String[] args) {
		ThreadEx2 th1 = new ThreadEx2("�۸���");
		ThreadEx2 th2 = new ThreadEx2("�߿���");
//		th1.start();
//		th2.start();

		ThreadEx2 th3 = new ThreadEx2("õ����");
		ThreadEx2 th4 = new ThreadEx2("�漳��");

		ThreadEx2[] thArr = new ThreadEx2[100];

		System.out.println("����");
		th3.start();
		th4.start();
		// �������
		try {
			th3.join();
			th4.join();
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("����");

	}

}// class end
