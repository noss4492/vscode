package day23;
// Thread�� ����ؼ� ȭ�鿡 1���� 100���� ����غ���.

public class LamdaEx12 extends Thread {
	public static void main(String[] args) {
		Thread th = new Thread() {

			@Override
			public void run() {
				for (int i = 1; i < 100; i++) {
//					System.out.println(Thread.currentThread().getName() + ":" + i);
				}
			}

		};
		th.start();
		System.out.println("--------");

		
		Runnable r = () -> {
			for (int i = 1; i < 100; i++) {
				System.out.println("ho" + Thread.currentThread().getName() + ":" + i);
			}
		};
		Thread th1 = new Thread(r);
		th1.start();

//		Thread th2 = new Thread(Runnable �������̽� ������ü);
//		th2.start();
		
//		new Thread(r).start(); r�� ���� r ����
		
//      ?!?!?!?!?!!?!  ???!
		new Thread(
			() -> {
			for (int i = 1; i < 100; i++) {
				System.out.println("ho" + Thread.currentThread().getName() + ":" + i);
			}
		}).start();

	}
}
