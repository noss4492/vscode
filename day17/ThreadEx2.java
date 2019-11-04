package day17;
/*
1. Thread 상속
2. run() override
3. start() : 실행
 */

public class ThreadEx2 extends Thread {
	ThreadEx2(String name) {
		super(name);
		// String 인자를 받는 생성자를 호출
		// 이름 받아서 쓰레드 이름으로

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
		ThreadEx2 th1 = new ThreadEx2("멍멍이");
		ThreadEx2 th2 = new ThreadEx2("야옹이");
//		th1.start();
//		th2.start();

		ThreadEx2 th3 = new ThreadEx2("천둥이");
		ThreadEx2 th4 = new ThreadEx2("흑설탕");

		ThreadEx2[] thArr = new ThreadEx2[100];

		System.out.println("시작");
		th3.start();
		th4.start();
		// 대기해조
		try {
			th3.join();
			th4.join();
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("종료");

	}

}// class end
