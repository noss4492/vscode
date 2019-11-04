package day17;
// 메모리를 할당받아 실행중인 프로그램 ==> 프로세스
// 프로그램내에서 실행되는 흐름의 단위 ==> Thread
// 자바는 Multi Thread 지원

// 동시에... ? 멀티테스크 처리하려면... ?
// 1. Thread 상속받아서 
// 2. Runnable 인터페이스를 구현해서


public class ThreadEx1 extends Thread {	// 기본적으로 Main Thread
	public static void main(String[] args) {
		Thread th = Thread.currentThread();	//Returns a reference to the currently executing thread object.
		System.out.println(th.getName());
	}
}
