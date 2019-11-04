package day17;

// 1. Runnable interface 구현
// 2. run() override
// 3. 이 객체를 생성
// 4. Thread 클래스의 생성자에 넣기
// 5. Thread 클래스 객체를 통해서 start() 호출

public class ThreadEx3 implements Runnable {
	String name;

	public ThreadEx3(String name) {
		super();
		this.name = name;
	}

	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(name+" : "+i+" 미터 달리는 중");
		}
	}
	
	public static void main(String[] args) {
		ThreadEx3 r1 = new ThreadEx3("토끼이");
		ThreadEx3 r2 = new ThreadEx3("거북이");

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
