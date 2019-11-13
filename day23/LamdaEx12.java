package day23;
// Thread를 사용해서 화면에 1부터 100까지 출력해보자.

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

//		Thread th2 = new Thread(Runnable 인터페이스 구현객체);
//		th2.start();
		
//		new Thread(r).start(); r에 위에 r 대입
		
//      ?!?!?!?!?!!?!  ???!
		new Thread(
			() -> {
			for (int i = 1; i < 100; i++) {
				System.out.println("ho" + Thread.currentThread().getName() + ":" + i);
			}
		}).start();

	}
}
